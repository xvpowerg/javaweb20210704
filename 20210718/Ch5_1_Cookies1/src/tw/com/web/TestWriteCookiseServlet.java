package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testWriteCookie")
public class TestWriteCookiseServlet extends HttpServlet  {
	//�ϥ� ?addCookise=true �إ߷s��loginTime �P id cookise
	//�ϥ� del = loginTime �R�� loginTime �p�G�O del=id �N�R��id
	
	
private void addCookie(HttpServletResponse resp) {
	Random ran = new Random();
	//�w�]���p�s��������Cookie�N����
	Cookie coo1 = new Cookie("loginTime",LocalDateTime.now().toString());
	//setMaxAge ���O��
	// 1 ��   60 * 60 * 24
	//3����  60 * 3
	coo1.setMaxAge(60 * 3);
	Cookie coo2 = new Cookie("id",ran.nextInt(10000)+"");
	coo2.setMaxAge(60 * 5);			
	//�s����������cookie���� 
	coo2.setMaxAge(-1);		
	resp.addCookie(coo1);
	resp.addCookie(coo2);
}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =   resp.getWriter();
		
		out.println("Test Cookie!");
		String addCookise = req.getParameter("addCookise");
		String del = req.getParameter("del");	
		
		if (Boolean.parseBoolean(addCookise)) {			
			addCookie(resp);
		}
		
		if (del != null) {
			Cookie cookie = new Cookie(del,"");		
			//�R��
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		
		
	}
}
