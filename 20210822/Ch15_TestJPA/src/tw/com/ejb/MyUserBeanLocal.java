package tw.com.ejb;

import javax.ejb.Local;

import tw.com.jpa.MyUser;

@Local
public interface MyUserBeanLocal {
		boolean createUser(MyUser myUser);
		boolean updateUser(MyUser myUser);
		boolean deleteUser(MyUser myUser);
		MyUser findMyUser(String account,String password);
		MyUser findMyUserById(int id);
}
