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
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Page1 resp:"+resp.hashCode());
		//resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<img width=\"20%\" height=\"20%\" alt=\"images/image1.png\" src=\"images/image1.png\">");
		
		List<Product> plist=  (List<Product>)req.getAttribute("pList");
		out.println("<ol>");
		for (Product p : plist) {
			int price = p.getPrice()-5;
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
