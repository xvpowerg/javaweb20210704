package tw.com.web;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//預設是-1表示 第一次呼叫時建立
//不是-1 表示運行容器時 建立Servlet
@WebServlet(urlPatterns = {"/page3"},loadOnStartup = 2)
public class Page3Servlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("Page3Servlet......Init Start1!!");
		try {TimeUnit.SECONDS.sleep(5);}catch(Exception ex) {}				
		System.out.println("Page3Servlet......Init Start2!!");		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().print("page3!!");
	}
}
