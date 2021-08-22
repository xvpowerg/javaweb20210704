package tw.com.ws;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class UserRestful {
	@EJB
	private MyUserBeanLocal myUserBean;
	@POST
	public String createUser(@FormParam("account") String account,
			@FormParam("password") String password) {
			String json = "";
				MyUser myUser = new MyUser();
				myUser.setAccount(account);	
				myUser.setPassword(password);
				myUserBean.createUser(myUser);
				//Jackson ª«¥óÂàJOSN
				ObjectMapper objMap = new ObjectMapper();
				try {
					json = objMap.writeValueAsString(myUser);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			return json;
		
	}
	
}
