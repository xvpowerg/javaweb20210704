package tw.com.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitDbListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		DbInfo.setDbAccount(context.getInitParameter("db_account"));
		DbInfo.setDbPassword(context.getInitParameter("db_password"));
		DbInfo.setDbName(context.getInitParameter("db_name"));
		DbInfo.setDbType(context.getInitParameter("db_type"));
	}

}
