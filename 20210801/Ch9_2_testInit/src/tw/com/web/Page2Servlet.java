package tw.com.web;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�w�]�O-1��� �Ĥ@���I�s�ɫإ�
//���O-1 ��ܹB��e���� �إ�Servlet
@WebServlet(urlPatterns = {"/page2"},loadOnStartup = 3)
public class Page2Servlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("Page2Servlet......Init Start1!!");
		try {TimeUnit.SECONDS.sleep(5);}catch(Exception ex) {}				
		System.out.println("Page2Servlet......Init Start2!!");		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().print("page2!!");
	}
}
