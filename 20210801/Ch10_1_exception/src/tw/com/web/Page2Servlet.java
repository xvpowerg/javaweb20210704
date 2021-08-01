package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.exception.MyException;
@WebServlet("/page2")
public class Page2Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String test = req.getParameter("test");
		System.out.print("test:"+test);
		if (Boolean.parseBoolean(test)) {			
			throw new MyException();
		}
		resp.getWriter().println("Page2");
	}
}
