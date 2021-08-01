package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page2")
public class Page2Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().print("Page2");
	}
//不建議複寫	 service(ServletRequest req, ServletResponse res)
	//可能導致忘記呼叫 service(HttpServletRequest req, HttpServletResponse resp)失去呼叫doGet或doPost....能力
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Page2Servlet!!!");
		//service((HttpServletRequest)req,(HttpServletResponse)res);
	}
}
