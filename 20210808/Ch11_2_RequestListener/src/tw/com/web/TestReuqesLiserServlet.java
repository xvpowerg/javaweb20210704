package tw.com.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/trl")
public class TestReuqesLiserServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			LocalDateTime dateTime = 
					(LocalDateTime)req.getAttribute("timeStamp");
			System.out.println("dateTime:"+dateTime);
		}
}
