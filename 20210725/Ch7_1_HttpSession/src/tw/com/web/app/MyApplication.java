package tw.com.web.app;

import java.util.HashMap;
import java.util.Map;

public class MyApplication {
	 static final  Map<String,String> itemsMap = 
			 new HashMap<>();
	static {
		itemsMap.put("1", "Âû¯İ");
		itemsMap.put("2", "¤û¦×");
		itemsMap.put("3", "ÂD³½");
		itemsMap.put("4", "Stream Deck");
		itemsMap.put("5", "PS6");
		itemsMap.put("6", "RTX4090");
	}
	public static String getItem(String key) {
		return itemsMap.get(key);
	}
	
}
