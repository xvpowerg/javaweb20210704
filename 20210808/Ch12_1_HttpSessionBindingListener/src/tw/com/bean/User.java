package tw.com.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{
	private String name;
	private int age;
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		User user = (User)event.getSession().getAttribute("myuser");
		System.out.println("valueBound Session:"+user);		
		System.out.println("valueBound Event:"+event.getValue());
		System.out.println("===========================");		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		User user = (User)event.getSession().getAttribute("myuser");
		System.out.println("valueUnbound Session:"+user);		
		System.out.println("valueUnbound Event:"+event.getValue());
		System.out.println("===========================");
	}
	public User() {
		super();
		}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+":"+age;
	}
}
