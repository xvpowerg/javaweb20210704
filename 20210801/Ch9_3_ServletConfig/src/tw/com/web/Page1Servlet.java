package tw.com.web;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="page1",urlPatterns = {"/page1"})
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p1 = getServletConfig().getInitParameter("path");
		String p2 =  this.getInitParameter("path");//建議呼叫 因為比較短
		String count = this.getInitParameter("count");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(count);
		String path= p1;
		//"C:\\MyDir\\test.txt";
		PrintWriter out = 	resp.getWriter();
		out.print("path:"+path);
		FileWriter fw = new  FileWriter(path);
		fw.write("ABCDEFG!!!");
		fw.close();
		
	}
}
