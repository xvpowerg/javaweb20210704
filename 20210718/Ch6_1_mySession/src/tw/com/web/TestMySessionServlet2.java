package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.tools.MySession;
import tw.com.web.tools.WebApplication;
@WebServlet("/testSession2")
public class TestMySessionServlet2 extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			MySession mysession = WebApplication.
					getSession(req, resp);
			System.out.println(mysession.getAttribute("value1"));
			User user = (User)mysession.getAttribute("user");
			if (user!= null) {
				System.out.println(user);
			}
	
		}
}
