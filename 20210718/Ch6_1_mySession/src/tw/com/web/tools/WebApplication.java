package tw.com.web.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebApplication {
	public static final String MY_SESSION_ID="MY_SESSION_ID";
	private static Map<String,MySession> sessionMap = new HashMap();
	private WebApplication() {}
	
	public static MySession getSession(HttpServletRequest req, HttpServletResponse resp) {
		return getSession(req,resp,true);
	}
	public static MySession getSession(HttpServletRequest req, HttpServletResponse resp,boolean createSession) {
		MySession mySession = null;
		Cookie[] cookieArray =   req.getCookies();
		if (cookieArray != null) {
			Optional<Cookie> cookieOpt =  Stream.of(cookieArray).
			  filter(c->c.getName().equals(MY_SESSION_ID)).
			  findFirst();
			if (cookieOpt.isPresent()) {
				String mySessionId = cookieOpt.get().getValue();
				mySession = sessionMap.get(mySessionId);
				if (mySession != null)  return mySession;								
			}
		}
		
		
		if (createSession) {
			mySession = createSession(resp);
		}
		return mySession;
	}
	
	private static MySession createSession(HttpServletResponse resp) {
		MySession mySession = new MySession();
		//���ͤ@�� SeessioniID���ü�
		long sessionID = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
		
		// SeessioniID �ର16�i��
		String sessionIdStr = Long.toHexString(sessionID);
		//�إߤ@��MySession ��JsessionMap �� key:SeessioniID value:MySession
		sessionMap.put(sessionIdStr, mySession);
		//�NSeessioniID�[�Jcookie 
		Cookie cookie = new Cookie(MY_SESSION_ID,sessionIdStr);
		resp.addCookie(cookie);
		return mySession;
	}
	
}
