package tw.com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import tw.com.bean.User;
@WebListener
public class MyHttpAttListener  implements HttpSessionAttributeListener{
@Override
public void attributeAdded(HttpSessionBindingEvent event) {
	// TODO Auto-generated method stub	
	User user = (User)event.getSession().getAttribute("myuser");
	System.out.println("add:"+user);
	System.out.println(event.getName()+" add "+event.getValue());
}
@Override
public void attributeReplaced(HttpSessionBindingEvent event) {
	// TODO Auto-generated method stub	
	User user = (User)event.getSession().getAttribute("myuser");
	System.out.println("Replace:"+user);
	//event.getValue 是沒修改過的
	System.out.println(event.getName()+" Replace "+event.getValue());
}
@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	User user = (User)event.getSession().getAttribute("myuser");
	System.out.println("Removed:"+user);
	System.out.println(event.getName()+" Removed "+event.getValue());
	}

}
