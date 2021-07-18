package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/testSession2")
public class TestHttpSessionServlet2  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//預設 如果Session不存在會建立新的Session
		HttpSession session =   req.getSession();
		String msg = (String)session.getAttribute("msg");
		Item item = (Item)session.getAttribute("item");
		if (item != null) {
			System.out.println(item);
		}
		System.out.println(msg);
	}
}
