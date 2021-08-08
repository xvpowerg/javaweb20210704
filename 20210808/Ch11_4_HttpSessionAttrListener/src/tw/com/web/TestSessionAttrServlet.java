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

@WebServlet("/testSA")
public class TestSessionAttrServlet extends HttpServlet {
			@Override
			protected void doGet(HttpServletRequest req,
					HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				String action = req.getParameter("action");
				HttpSession session = req.getSession();
				PrintWriter out = resp.getWriter();
				if (action != null) {
					switch(action) {
						case "add":
							User myUser1 = new User("Ken",10);
							session.setAttribute("myuser", myUser1);
							out.print("Add");
							break;
						case "replace":
							User myUser2 = new User("Iris",18);
							session.setAttribute("myuser", myUser2);
							out.print("Replace");
							break;	
						case "del":
							session.removeAttribute("myuser");
							out.print("Del");
							break;
					}
										
				}
			}
}
