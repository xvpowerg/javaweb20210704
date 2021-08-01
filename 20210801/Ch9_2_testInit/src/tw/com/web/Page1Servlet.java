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
//loadOnStartup �Ʀr�p���V������ �@�ˤ��T�w
@WebServlet(urlPatterns = {"/page1"},loadOnStartup = 1)
public class Page1Servlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("Page1Servlet......Init Start1!!");
		try {TimeUnit.SECONDS.sleep(5);}catch(Exception ex) {}				
		System.out.println("Page1Servlet......Init Start2!!");		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().print("page1!!");
	}
}
