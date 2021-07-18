package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookies")
public class TestReadCookies extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter out =   resp.getWriter();
			Cookie[] cookies =  req.getCookies();
			String[] filterArray = req.getParameterValues("filter");
			
			Set<String> filterSet = new HashSet<>();
			if (filterArray != null) {				
				for (String f : filterArray) {
					filterSet.add(f);
				}				
			}
		
			//�ݨD 1 �b�s�����W ��XCookie �M��
			// 1 id:5187
			// 2 loginTime:2021-07-18T11:29:22.446
			
//			<html>
//				<body>
//					<li>
//					<ol>id:5187</ol>
//					<ol>loginTime:2021-07-18T11:29:22.446</ol>
//					</li>
//				</body>			
//			<html>
			
			//�ݨD 2 �[�J�@��filter �Ѽ�
			//readCookies?filter=id �N�u���id
			//readCookies?filter=id&filter=loginTime �N���id�PloginTime
			//�p�G�S��filter �N�������
			if (cookies != null) {								
				Stream<Cookie> cookiesStr = Stream.of(cookies);				
				//cookiesStr.forEach(c->System.out.println(c.getName()+":"+c.getValue()));
				String cookieList = cookiesStr.filter(c->filterSet.isEmpty() || 
						filterSet.contains(c.getName())).map(c->String.format("<li>%s</li>",
						c.getName()+":"+c.getValue())).
				collect(Collectors.joining("\n", "<ol>", "</ol>"));
				out.println("<html><body>"+cookieList+"</body></html>");
			}else {
				out.println("Cookie Empty!!");
			}
			
		}
}
