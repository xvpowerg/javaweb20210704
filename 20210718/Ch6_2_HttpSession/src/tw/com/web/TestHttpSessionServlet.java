package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/testSession")
public class TestHttpSessionServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�w�] �p�GSession���s�b�|�إ߷s��Session
		HttpSession session =   req.getSession();
		Item item1 = new Item();
		item1.name = "Ps5";
		item1.price = 56000;
		session.setAttribute("msg", "Hello!!");
		session.setAttribute("item", item1);
		//�]�w�ϱoSession�L��
		//session.invalidate();
		//HttpSession session = req.getSession(false);
		System.out.println(session);
	}
}
