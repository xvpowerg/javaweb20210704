package tw.com.web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AuthTable {
	
	private static Map<String,Set<String>> authMap = new HashMap<>();
	
	static {
		
		Set<String> userSet = new HashSet<>();
		Set<String> adminSet = new HashSet<>();
		
		userSet.add("Ken");
		userSet.add("Vivin");
		userSet.add("Boss");
		
		adminSet.add("Iris");
		adminSet.add("Lucy");
		adminSet.add("Boss");
		
		authMap.put("user",userSet);
		authMap.put("admin",adminSet);		
	}
	
	
	public static void addUser(String user) {
		authMap.get("user").add(user);
	}
	public static void addAdmin(String user) {
		authMap.get("admin").add(user);
	}
	
	public static boolean canUser(String user) {
		if (authMap.isEmpty()) return false;
		
		return authMap.get("user").contains(user);
	}
	public static boolean canAdmin(String user) {
		if (authMap.isEmpty()) return false;
		return authMap.get("admin").contains(user);
	}
		
}
