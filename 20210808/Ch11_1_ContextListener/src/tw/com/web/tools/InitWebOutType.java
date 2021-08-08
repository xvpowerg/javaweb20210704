package tw.com.web.tools;
import javax.servlet.http.HttpServletResponse;

public class InitWebOutType {
	public enum WebOutType{
		HTML_UTF8,
		JSON_UTF8
	}
		private static String htmlTypeStr;
		private static String jsonTypeStr;
		
		static void setTypeStr(WebOutType type,String typStr) {
			switch(type) {
				case HTML_UTF8:
					htmlTypeStr = typStr;
					break;
				case JSON_UTF8:
					jsonTypeStr = typStr;
					break;	
			}
		}
		
		public static void setWebType(HttpServletResponse resp,WebOutType type) {
			String typeString = "";
			switch(type) {
			case HTML_UTF8:
				typeString = htmlTypeStr;
				break;
			case JSON_UTF8:
				typeString = jsonTypeStr;
				break;	
			}
			resp.setContentType(typeString);		
		}
		
		public static void toUtf8Html(HttpServletResponse resp) {
			setWebType(resp,WebOutType.HTML_UTF8);
		}
		public static void toUtf8Json(HttpServletResponse resp) {
			setWebType(resp,WebOutType.JSON_UTF8);
		}
		
		
}
