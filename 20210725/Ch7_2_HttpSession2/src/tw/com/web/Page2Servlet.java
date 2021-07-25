package tw.com.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.Item;
import tw.com.web.app.WebTools;
@WebServlet("/page2")
public class Page2Servlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			String[] itemIds =   req.getParameterValues("itemsId");
			Optional<List<Item>> itemOpt =  
					WebTools.genItemList(itemIds);
			if (itemOpt.isPresent()) {
				List<Item> itemList = itemOpt.get();				
				WebTools.appendItemToSession(req.getSession(), itemList);
			}
			
			resp.sendRedirect("index.html");
		}
}
