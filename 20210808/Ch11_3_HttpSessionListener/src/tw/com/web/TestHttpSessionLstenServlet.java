package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/testSL")
public class TestHttpSessionLstenServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			PrintWriter out = resp.getWriter();	
			String login = 
						req.getParameter("login");
				String logout =  
						req.getParameter("logout");
				HttpSession session = null;
				if (Boolean.parseBoolean(login)) {
					session = req.getSession();
					out.println("login");
				}else if(Boolean.parseBoolean(logout)) {
					session = req.getSession();
					session.invalidate();
					out.println("logout");
				}
		}
}
