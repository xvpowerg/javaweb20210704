package tw.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.web.AuthTable;

@WebFilter("/user/*")
public class UserFilter  implements Filter {

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httReque =
				(HttpServletRequest)request;
//		User userObj = httReque.getSession().getAttribute("userInfo");
		// TODO Auto-generated method stub
		System.out.println("UserFilter!!");		
		String user = request.getParameter("user");
		//檢查是否可進入
		if (AuthTable.canUser(user)) {
			chain.doFilter(request, response);
		}else {
		HttpServletResponse httpResp = (HttpServletResponse)response;
		httpResp.sendRedirect("../index.html");
		}
	}

}
