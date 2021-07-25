package tw.com.web.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import tw.com.bean.Item;
import java.util.Optional;
import java.util.HashMap;

public class WebTools {
	
	public static final String ITEM_SESSION_NAME = "tmpItemMap";
	public static Optional<List<Item>>
				genItemList(String[] itemIds){
		if(itemIds == null) {
			return Optional.empty(); 
		}
		List<Item> itemList = Stream.of(itemIds).map(
				it->MyApplication.getItem(it)).
				collect(Collectors.toList());
		return Optional.of(itemList);
	}
	
	
	public static List<Item> getSessionItemList(HttpSession session) {
		List<Item> itemList = new ArrayList<>();
		HashMap<Item,Item> tmpMap = (HashMap)session.
				getAttribute(ITEM_SESSION_NAME);
		if (tmpMap != null) {
			itemList = tmpMap.values().stream().collect(Collectors.toList());
		}
		return itemList;
	}
	
	public static void appendItemToSession( HttpSession session,
			List<Item> itemList) {
		HashMap<Item,Item> itemMap = new HashMap<>();
		 //§PÂ_itemList ¬O§_¦s¦b
		HashMap<Item,Item> tmpMap = (HashMap)session.
				getAttribute(ITEM_SESSION_NAME);
		 
		 if (tmpMap!= null)  itemMap = tmpMap;
		 
		 for(Item item : itemList) {
			 if (itemMap.containsKey(item)) {
				 item =  itemMap.get(item);
			 }
			 item.addCount();
			 itemMap.put(item, item);	 			 
		 }
		
		 session.setAttribute(ITEM_SESSION_NAME, itemMap);			
	}
}
