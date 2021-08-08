package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginJson")
public class LoginServletJson  extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String defAccount = "qwer";
			String defPassword = "12345";
			String account = req.getParameter("account");
			String password = req.getParameter("password");
			String json ="{\"msg\":\"%s\",\"isLogin\":%b,\"location\":\"%s\"}";
			
			String msg = "";
			boolean isLogin = false;
			String location = "";
			//設定輸出成為json格式
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter out = resp.getWriter();
			if (defAccount.equals(account) &&
					defPassword.equals(password)) {
				msg = "登入成功";
				isLogin = true;
				location = "user.html";
			}else {
				msg = "登入失敗";
			}
			json = String.format(json, msg,isLogin,location);
			out.print(json);
		}
}
