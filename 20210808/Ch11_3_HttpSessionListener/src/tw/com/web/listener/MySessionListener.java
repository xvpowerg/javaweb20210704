package tw.com.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class MySessionListener  implements HttpSessionListener{
		@Override
		public void sessionCreated(HttpSessionEvent se) {
			System.out.println("sessionCreated �n�J");
			
		}
		@Override
		public void sessionDestroyed(HttpSessionEvent se) {			
			System.out.println("sessionDestroyed �n�X");
		}
}
