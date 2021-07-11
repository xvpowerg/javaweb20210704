package tw.com.web.tools;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import tw.com.bean.Product;

public class FoodsTool {
	
	static String[]priceArray = {"85","75","65"};
	
	public static List<Product> getProduct(HttpServletRequest req){
		String[] foods =req.getParameterValues("food");
		String deliverys = req.getParameter("delivery");
		List<Product> pList = new ArrayList<>();
		for (String foodStr : foods) {
			//String name, String price, String count, String sales
			int index = Integer.parseInt(foodStr);
			String price = priceArray[index];
			String count = req.getParameter("count"+index);
			Product p1 = new Product(foodStr,price,count,deliverys);
			pList.add(p1);
		}
		return pList;
	}
}
