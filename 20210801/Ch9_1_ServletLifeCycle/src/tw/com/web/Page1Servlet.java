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
	//����ɭ�New(�إ�Servlet����)?
	//	�w�]���p�U �e���|�b �Ĥ@��ϥΪ̩I�sServlet new
	//�إ߮ɰ������?
	// 1 ���NServlet����إ� �o���٤��O�u��Servlet
	// 2 �I�s��إߪ�Servlet����init(ServletConfig)��k
	// 3 �binit(ServletConfig)�I�sinit()	
	//�إߴX��?
	   //�P�@Servlet�u�|�إߤ@��
	   //�N��C��Servlet����b��e�e���ۦP�O����Ŷ�		
	//�����������?
		//�|�I�s destory() �i�������귽
	
	//�I�sServlet�������?
	//1 �e�����즳�T�� ��۹�����Servlet 
	//�p�G�s�b�N�إ߷s�������(Thread)�I�s��Servlet 
	//��service(ServletRequest req, ServletResponse res)
	//���I�s service(HttpServletRequest req, HttpServletResponse resp)
	//service(Htt, Http)�P�w�OdoPost�٬OdoGet......
		
		
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ServletContext app =   getServletContext();//���O�I�sconfig.getServletContext()
			System.out.println(app);
			//�ҩ��p�G�s�b�N�إ߷s�������(Thread)�I�s�H�إߪ�Servlet���� 
			//Thread Name�|���ۦP  Servlet hashCode�]�ӬۦP
			System.out.print("Thread:"+Thread.currentThread().getName()+":"+this.hashCode());
			
		}
			
		//��l�Ƥ@�ǰѼ�
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
		System.out.println("init()");
		}

//		@Override
		public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			
			System.out.println("init(ServletConfig config)");				
			//1 ���|�I�sinit()
			//2 ServletConfig �]���|�Q�]�w
			super.init(config); //�p�G�S�I�sServletConfig ���|�Q�]�w ���|�I�sinit()
								  //�I�sgetServletContext �|����NullPointerException
		}
}
