package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.tools.BaseInfoTools;
@WebServlet("/page2")
public class Page2Servlet extends HttpServlet{
	
	static final String[] HOBBY_ARRAY= {"閱讀","音樂","運動","下棋"};
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();			
		List<String> hobbys= 
				BaseInfoTools.getHobbys(req);
		for (String hobby : hobbys) {
			out.print(hobby);
		}	
		
		String status = BaseInfoTools.getStatus(req);
		out.print(status);
				
		Map<String,String[]> map = req.getParameterMap();
		System.out.println(map);
		map.forEach((k,vs)->{
			System.out.print(k+":");
			Stream.of(vs).forEach(System.out::print);
		});
	}
}
