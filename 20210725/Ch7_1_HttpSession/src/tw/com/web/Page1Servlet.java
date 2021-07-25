package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.web.app.MyApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub			
			String[] itemIds =   req.getParameterValues("itemsId");
			//假設都有選產品
			if (itemIds != null) {
			List<String> itemList = Stream.of(itemIds).map(
						it->MyApplication.getItem(it)).
						collect(Collectors.toList());
			
			 HttpSession session =  req.getSession();
			 List<String> tmpItemList = new ArrayList<>();
			 //判斷itemList 是否存在
			 List tmpList = (List)session.getAttribute("itemList");
			 if (tmpList!= null)  tmpItemList = tmpList;  			 
			 tmpItemList.addAll(itemList);
			 session.setAttribute("itemList", tmpItemList);			 
			}
			//透過瀏覽器轉換頁面
			//status code 為 302
			//Location: 存放要轉換的頁面
			resp.sendRedirect("index.html");
			
		}
}
