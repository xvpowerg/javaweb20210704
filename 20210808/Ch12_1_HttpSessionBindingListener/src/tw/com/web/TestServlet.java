package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.bean.User;
@WebServlet("/testBind")
public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		if (action!= null) {
			switch(action) {
			case  "add":
				User myuser = new User("Vivin",10);
				session.setAttribute("myuser", myuser);
				out.print("add");
				break;
			case  "replace":
				User myuser2 = new User("Lucy",20);
				session.setAttribute("myuser", myuser2);
				out.print("replace");
				break;
			case  "del":			
				session.removeAttribute("myuser");
				out.print("del");
				break;	
	
			}
			
		}
	}
}
