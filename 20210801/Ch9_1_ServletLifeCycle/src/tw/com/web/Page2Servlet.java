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
//����ĳ�Ƽg	 service(ServletRequest req, ServletResponse res)
	//�i��ɭP�ѰO�I�s service(HttpServletRequest req, HttpServletResponse resp)���h�I�sdoGet��doPost....��O
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Page2Servlet!!!");
		//service((HttpServletRequest)req,(HttpServletResponse)res);
	}
}
