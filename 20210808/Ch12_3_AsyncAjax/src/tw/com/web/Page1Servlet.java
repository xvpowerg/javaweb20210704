package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/page1"},asyncSupported = true)
public class Page1Servlet  extends HttpServlet{
	private ExecutorService es = Executors.newCachedThreadPool();
		@Override
		protected void doGet(HttpServletRequest req, 
				HttpServletResponse resp) throws ServletException, IOException {
			Random ran = new Random();
			resp.setContentType("text/html;charset=UTF-8");
			 AsyncContext ctx =  req.startAsync();
			es.execute(()->{
					try {					
						System.out.println("開始工作");
						PrintWriter out = ctx.getResponse().
								getWriter();						
						TimeUnit.SECONDS.sleep(5);
						int max  = ran.nextInt(Integer.MAX_VALUE);
						out.print("完成工作:"+max);		
						System.out.println("完成工作");
						ctx.complete();
					}catch(Exception ex) {
						System.out.println(ex);
					}
				
			});
			
		
		}
}
