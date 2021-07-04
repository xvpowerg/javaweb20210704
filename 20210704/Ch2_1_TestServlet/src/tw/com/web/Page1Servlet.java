package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	//HttpServletResponse ¿é¥X
	//HttpServletRequest ¿é¤J
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		PrintWriter out =  response.getWriter();
		out.println("<html>");
		
		out.println("<body>");
			out.println("<p>value1</p>");
			out.println("<p>value2</p>");
			out.println("<p>value3</p>");
			out.println("Test1!");
			out.println("Test2!");
		out.println("</body>");
		
		out.println("</html>");			
	}
}
