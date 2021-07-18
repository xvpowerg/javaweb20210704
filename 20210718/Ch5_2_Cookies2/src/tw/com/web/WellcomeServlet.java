package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wellcome")
public class WellcomeServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("username");
		//�Ʊ���� �ϥΪ̲ĴX���n�J
		Cookie[] cookies =   req.getCookies();
		cookies = cookies == null?new Cookie[0]:cookies;		
		
		Stream<Cookie> stream = Stream.of(cookies);
	 Optional<Cookie>cookieOpt = 
			 stream.filter(c->c.getName().equals(name)).findFirst();
	 //�p�GcookieOpt���]�t�@��Cookie �N�^�� �_�h�^�ǹw�]Cookie
	 Cookie countCookie= cookieOpt.orElseGet(()->new Cookie(name, "0"));
	 String countStr = countCookie.getValue();
	 int count = Integer.parseInt(countStr);
	 count++;
	 countCookie.setValue(count+"");	   
	 //8�p�ɹL��
	 countCookie.setMaxAge(60*60*8);
	 out.print(String.format("<H1>%s ��%d���n�J</H1>", name,count));	 
	 resp.addCookie(countCookie);
		
	}
}
