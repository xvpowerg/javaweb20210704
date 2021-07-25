package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.bean.Item;
import tw.com.web.app.WebTools;
@WebServlet("/itemList")
public class ItemListServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			resp.setContentType("text/html;charset=utf-8");		
//			PrintWriter out = resp.getWriter();
			// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		List<Item> list =  WebTools.getSessionItemList(session);
		req.setAttribute("itemList",list);
		req.getRequestDispatcher("/item_list.jsp").forward(req, resp);				
//		System.out.println(list);
//		String itemLi = list.stream().map(its->"<li>"+its+"</li>").		
//		collect(Collectors.joining("", "<ol>", "</ol>"));
//		out.print(itemLi);
		
		
		
		//System.out.println(list);
			//resp.sendRedirect("item_list.jsp");
		
		}
}
