package tw.com.web.app;

import java.util.HashMap;
import java.util.Map;

import tw.com.bean.Item;

public class MyApplication {
	 static final  Map<String,Item> itemsMap = 
			 new HashMap<>();
	static {
		itemsMap.put("1", new Item(1,"Âû¯Ý"));
		itemsMap.put("2", new Item(2,"¤û¦×"));
		itemsMap.put("3", new Item(3,"ÂD³½"));
		itemsMap.put("4", new Item(4,"Stream Deck"));
		itemsMap.put("5", new Item(5,"PS6"));
		itemsMap.put("6", new Item(6,"RTX4090"));
	}
	public static Item getItem(String key) {
		return itemsMap.get(key);
	}
	
}
