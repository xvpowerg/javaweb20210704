package tw.com.web.tools;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tw.com.web.tools.InitWebOutType.WebOutType;
@WebListener
public class InitWebOutTypeListener  
				implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String outHtml = context.getInitParameter("outHtml");
		String jsonHtml = context.getInitParameter("outJson");
		
		if (outHtml != null) {
			InitWebOutType.
			setTypeStr(WebOutType.HTML_UTF8, outHtml);
		}
		if (jsonHtml != null) {
			InitWebOutType.
			setTypeStr(WebOutType.JSON_UTF8, jsonHtml);
		}
		
	}
}
