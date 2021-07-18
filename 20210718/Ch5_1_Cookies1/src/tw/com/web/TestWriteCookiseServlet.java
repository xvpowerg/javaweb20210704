package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testWriteCookie")
public class TestWriteCookiseServlet extends HttpServlet  {
	//使用 ?addCookise=true 建立新的loginTime 與 id cookise
	//使用 del = loginTime 刪除 loginTime 如果是 del=id 就刪除id
	
	
private void addCookie(HttpServletResponse resp) {
	Random ran = new Random();
	//預設情況瀏覽器關閉Cookie就結束
	Cookie coo1 = new Cookie("loginTime",LocalDateTime.now().toString());
	//setMaxAge 單位是秒
	// 1 天   60 * 60 * 24
	//3分鐘  60 * 3
	coo1.setMaxAge(60 * 3);
	Cookie coo2 = new Cookie("id",ran.nextInt(10000)+"");
	coo2.setMaxAge(60 * 5);			
	//瀏覽器關閉後cookie消失 
	coo2.setMaxAge(-1);		
	resp.addCookie(coo1);
	resp.addCookie(coo2);
}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =   resp.getWriter();
		
		out.println("Test Cookie!");
		String addCookise = req.getParameter("addCookise");
		String del = req.getParameter("del");	
		
		if (Boolean.parseBoolean(addCookise)) {			
			addCookie(resp);
		}
		
		if (del != null) {
			Cookie cookie = new Cookie(del,"");		
			//刪除
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		
		
	}
}
