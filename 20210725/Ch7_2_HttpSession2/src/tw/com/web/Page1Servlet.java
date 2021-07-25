package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.bean.Item;
import tw.com.web.app.MyApplication;
import tw.com.web.app.WebTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
