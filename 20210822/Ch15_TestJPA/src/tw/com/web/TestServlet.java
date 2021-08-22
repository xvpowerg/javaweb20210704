package tw.com.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;
@WebServlet("/tesjpa")
public class TestServlet extends HttpServlet {
	@EJB
	private MyUserBeanLocal myUserBean;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("tesjpa!!!");
		MyUser myUser = new MyUser();
		myUser.setAccount("ken");
		myUser.setPassword("123456");
		System.out.println(myUser);
		myUserBean.createUser(myUser);
		System.out.println(myUser);
		//修改必須有正確id
		myUser.setPassword("789");
		myUserBean.updateUser(myUser);		
		MyUser findMyUser = myUserBean.findMyUserById(myUser.getId());
		System.out.println(findMyUser);
		findMyUser = myUserBean.findMyUser(myUser.getAccount(), myUser.getPassword());
		System.out.println(findMyUser);
		
		//delUser.setId(findMyUser.getId());
		myUserBean.deleteUser(findMyUser);
	}
}
