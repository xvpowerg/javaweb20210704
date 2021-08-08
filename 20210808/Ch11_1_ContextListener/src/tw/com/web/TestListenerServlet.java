package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.tools.InitWebOutType;
@WebServlet("/testListener")
public class TestListenerServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, 
							HttpServletResponse resp) 
									throws ServletException, IOException {
			InitWebOutType.toUtf8Html(resp);
			resp.getWriter().println("¦­¦w¡I¡I");
		}
}
