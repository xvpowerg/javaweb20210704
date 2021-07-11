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
	
	static final String[] HOBBY_ARRAY= {"閱讀","音樂","運動","下棋"};
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();			
		//String hobbyType =req.getParameter("hobby");
		String statusType =req.getParameter("status");
		String myinfo = req.getParameter("myinfo");
		String[] hobbys = req.getParameterValues("hobby");
		for(String v : hobbys) {
				int index = Integer.parseInt(v);
			out.print(HOBBY_ARRAY[index]+":");
			System.out.println(HOBBY_ARRAY[index]);
		}
		
		out.print("自我介紹:"+myinfo);
		//System.out.println(hobbyType+":"+statusType);
	
	}
}
