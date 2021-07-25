package tw.com.web.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import java.util.Optional;
public class WebTools {
	public static Optional<List<String>>
				genItemList(String[] itemIds){
		if(itemIds == null) {
			return Optional.empty(); 
		}
		List<String> itemList = Stream.of(itemIds).map(
				it->MyApplication.getItem(it)).
				collect(Collectors.toList());
		return Optional.of(itemList);
	}
	
	public static void appendItemToSession( HttpSession session,
			List<String> itemList) {
		 List<String> tmpItemList = new ArrayList<>();
		 //§PÂ_itemList ¬O§_¦s¦b
		 List tmpList = (List)session.getAttribute("itemList");
		 if (tmpList!= null)  tmpItemList = tmpList;  			 
		 tmpItemList.addAll(itemList);
		 session.setAttribute("itemList", tmpItemList);			
	}
}
