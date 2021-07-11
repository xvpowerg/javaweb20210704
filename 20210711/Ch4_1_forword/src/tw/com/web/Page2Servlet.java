package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.Product;
@WebServlet("/page2")
public class Page2Servlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<img width=\"20%\" height=\"20%\" alt=\"images/image2.png\" src=\"images/image2.jpg\">");
		out.print("</body>");
		out.print("</html>");
		
		
		List<Product> plist=  (List<Product>)req.getAttribute("pList");
		out.println("<ol>");
		for (Product p : plist) {
			int price = p.getPrice();
			out.println("<li>");
			out.println(p.getName()+":");
			out.println(p.getCount()+":");
			out.println(price+":");			
			out.println(price*p.getCount());
			out.println("</li>");
		}
		out.println("</ol>");
		out.print("</body>");
		out.print("</html>");
		System.out.println("plist:"+plist);
	}
}
