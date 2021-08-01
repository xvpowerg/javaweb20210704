package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page")
public class Page1Servlet  extends HttpServlet {
	private final static ExecutorService service = Executors.newCachedThreadPool();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			System.out.println("Start Thread Name:"+Thread.currentThread().getName());	
			PrintWriter out =   resp.getWriter();
			service.execute(()->{
				LocalDateTime datatime = LocalDateTime.now();
				System.out.println("Start :"+datatime);
				try{TimeUnit.SECONDS.sleep(20);}catch(Exception ex) {}
				System.out.println("End :"+datatime);			
			});
							
			System.out.println("End Thread Name:"+Thread.currentThread().getName());
			
		}
		
		
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			service.shutdown();
		}
}
