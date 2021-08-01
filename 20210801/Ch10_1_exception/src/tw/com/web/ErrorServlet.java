package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			runReport(req,resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			runReport(req,resp);
		}
		void runReport(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("Error!!!!");
			String errorMsg = "";
			String image = "";
			Integer status_code = (Integer)req.getAttribute("javax.servlet.error.status_code");
			if (status_code!= null) {
				switch(status_code) {
				case 404:
					errorMsg ="你迷路了嗎?";
					image = "error404.png";
					break;
				case 405:
					errorMsg ="錯誤的方法優!!";
					image = "error404.png";
					break;
				}				
			}
			req.setAttribute("errorMsg", errorMsg);
			req.setAttribute("errorImage", image);
			req.getRequestDispatcher("error.jsp").forward(req, resp);
			Enumeration<String> e =  req.getAttributeNames();
			while(e.hasMoreElements()) {
				String key = e.nextElement();
				System.out.println(key+":"+req.getAttribute(key));
			}
		}
}
