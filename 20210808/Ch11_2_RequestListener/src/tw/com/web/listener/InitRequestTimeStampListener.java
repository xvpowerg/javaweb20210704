package tw.com.web.listener;

import java.time.LocalDateTime;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class InitRequestTimeStampListener implements ServletRequestListener {
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("requestInitialized");
		sre.getServletRequest().setAttribute("timeStamp",
				LocalDateTime.now());
		
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed");
		sre.getServletRequest().removeAttribute("timeStamp");
	}
}
