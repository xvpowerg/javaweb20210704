package tw.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/page1")
public class TestFilter implements Filter  {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("TestFilter doFilter!!!");
		//�i�Ψӱ��ެO�_�i�JServlet
		chain.doFilter(req, resp);
		System.out.println("End TestFilter doFilter!!!");
	}
		
}
