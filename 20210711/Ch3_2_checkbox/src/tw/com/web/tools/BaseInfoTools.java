package tw.com.web.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

public class BaseInfoTools {
	static final Map<String,String> hobbyMap = new HashMap<>();		
	static final Map<String,String> statusMap = new HashMap<>();
	static final String HOBBY_NAME ="hobby"; 
	static final String STATUS_NAME ="status"; 
	static {
		hobbyMap.put("0", "閱讀");
		hobbyMap.put("1", "音樂");
		hobbyMap.put("2", "運動");
		hobbyMap.put("3", "下棋");
		
		statusMap.put("0", "單身");
		statusMap.put("1", "已婚");
		statusMap.put("2", "一言難盡");
	}
 public static List<String> getHobbys(HttpServletRequest req) {
	String[] hobbyArray = req.getParameterValues(HOBBY_NAME);
	if (hobbyArray == null || hobbyArray.length == 0) {
		throw new NoSuchElementException("嗜好不可空白");
	}
	Stream<String> hobbyStream =  Stream.of(hobbyArray);
	 List<String> hobbyList =  hobbyStream.
			 map(v->hobbyMap.get(v)).
			 collect(Collectors.toList());
	 return hobbyList;
 }
 
 public static String getStatus(HttpServletRequest req) {
	 String status = req.getParameter(STATUS_NAME);
	 return statusMap.get(status);
 }
	
	
}
