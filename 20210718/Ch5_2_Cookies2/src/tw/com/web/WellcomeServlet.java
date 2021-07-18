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
		//希望顯示 使用者第幾次登入
		Cookie[] cookies =   req.getCookies();
		cookies = cookies == null?new Cookie[0]:cookies;		
		
		Stream<Cookie> stream = Stream.of(cookies);
	 Optional<Cookie>cookieOpt = 
			 stream.filter(c->c.getName().equals(name)).findFirst();
	 //如果cookieOpt內包含一個Cookie 就回傳 否則回傳預設Cookie
	 Cookie countCookie= cookieOpt.orElseGet(()->new Cookie(name, "0"));
	 String countStr = countCookie.getValue();
	 int count = Integer.parseInt(countStr);
	 count++;
	 countCookie.setValue(count+"");	   
	 //8小時過期
	 countCookie.setMaxAge(60*60*8);
	 out.print(String.format("<H1>%s 第%d次登入</H1>", name,count));	 
	 resp.addCookie(countCookie);
		
	}
}
