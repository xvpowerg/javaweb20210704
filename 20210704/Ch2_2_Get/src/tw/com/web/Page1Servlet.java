package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String countStr = req.getParameter("count");
		String user = req.getParameter("user");
		countStr = countStr == null?"0":countStr;
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		//out.print("page1!!"+countStr);
		int count = Integer.parseInt(countStr);
		out.println("<html>");
		out.println("<body>");
		out.println("<ol>");
		for(int i = 1; i <= count;i++) {
			out.println("<li>");
			out.println(user);
			out.println("</li>");
		}
		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
