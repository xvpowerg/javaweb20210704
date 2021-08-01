package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.exception.MyException;

import java.util.Enumeration;
@WebServlet("/myexception")
public class ExceptionServlet extends HttpServlet {
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
			Exception ex = (MyException)req.getAttribute("javax.servlet.error.exception");
			
			PrintWriter out = resp.getWriter();
			out.print("Exception!!!!:"+ex);
			//javax.servlet.error.exception 可取得Exception的物件
//			Enumeration<String> e =  req.getAttributeNames();
//			while(e.hasMoreElements()) {
//				String key = e.nextElement();
//				System.out.println(key+":"+req.getAttribute(key));
//			}
		}
}
