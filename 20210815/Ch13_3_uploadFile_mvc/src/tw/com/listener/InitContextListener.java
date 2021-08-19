package tw.com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tw.com.web.tools.Utils;
@WebListener
public class InitContextListener 
			implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	
		String imagePath = sce.getServletContext().
				getInitParameter("image_path");
		Utils.setImagePath(imagePath);
		
	}
}
