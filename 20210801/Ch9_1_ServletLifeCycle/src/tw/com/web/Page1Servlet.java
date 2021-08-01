package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	//Page1Servlet  
	//什麼時候New(建立Servlet物件)?
	//	預設情況下 容器會在 第一位使用者呼叫Servlet new
	//建立時做什麼事?
	// 1 先將Servlet物件建立 這時還不是真的Servlet
	// 2 呼叫剛建立的Servlet物件的init(ServletConfig)方法
	// 3 在init(ServletConfig)呼叫init()	
	//建立幾次?
	   //同一Servlet只會建立一次
	   //意思每個Servlet物件在當前容器相同記憶體空間		
	//結束做什麼事?
		//會呼叫 destory() 可手動釋放資源
	
	//呼叫Servlet做什麼事?
	//1 容器測到有訊號 找相對應的Servlet 
	//如果存在就建立新的執行序(Thread)呼叫此Servlet 
	//的service(ServletRequest req, ServletResponse res)
	//內呼叫 service(HttpServletRequest req, HttpServletResponse resp)
	//service(Htt, Http)判定是doPost還是doGet......
		
		
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ServletContext app =   getServletContext();//其實是呼叫config.getServletContext()
			System.out.println(app);
			//證明如果存在就建立新的執行序(Thread)呼叫以建立的Servlet物件 
			//Thread Name會不相同  Servlet hashCode因該相同
			System.out.print("Thread:"+Thread.currentThread().getName()+":"+this.hashCode());
			
		}
			
		//初始化一些參數
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
		System.out.println("init()");
		}

//		@Override
		public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			
			System.out.println("init(ServletConfig config)");				
			//1 不會呼叫init()
			//2 ServletConfig 也不會被設定
			super.init(config); //如果沒呼叫ServletConfig 不會被設定 不會呼叫init()
								  //呼叫getServletContext 會產生NullPointerException
		}
}
