package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.tools.MySession;
import tw.com.web.tools.WebApplication;
@WebServlet("/testSession")
public class TestMySessionServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			MySession mysession = WebApplication.
					getSession(req, resp);
			mysession.setAttrubute("value1", "Test1");
			
			User user = new User();
			user.name = "Ken";
			user.age = 31;
			mysession.setAttrubute("user", user);
		}
}
