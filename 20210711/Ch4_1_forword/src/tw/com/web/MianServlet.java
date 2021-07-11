package tw.com.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.Product;
import tw.com.web.tools.FoodsTool;
@WebServlet("/main")
public class MianServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
//		String[] foods =  req.getParameterValues("food");
//		for (String f : foods) {
//			System.out.println(f);
//		}
//
//		Map<String,String[]> map = req.getParameterMap();
//		map.forEach((k,v)->System.out.println(k));
		
		List<Product> list = FoodsTool.getProduct(req);
		req.setAttribute("pList", list);
		System.out.println("main resp:"+resp.hashCode());
		//外送平台哪一間 
		if (list.get(0).getSales() == 0) {
			req.getRequestDispatcher("/page1").forward(req, resp);				
		}else {			
			req.getRequestDispatcher("/page2").forward(req, resp);				
		}
		
	}
}
