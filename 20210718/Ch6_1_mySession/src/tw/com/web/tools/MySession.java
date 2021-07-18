package tw.com.web.tools;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MySession implements Serializable {
	private Map<String,Object> data = new HashMap<>();
	MySession(){}
	
	public Object getAttribute(String name) {
		return data.get(name);
	}
	
	public void setAttrubute(String name,Object obj) {
		data.put(name, obj);
	}
}
