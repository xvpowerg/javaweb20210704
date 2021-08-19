package tw.com.cdi;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import tw.com.bean.Student;

public class MyProduces {

	@Produces
	@Named("Ken")
	private Student getKenStudent() {
		Student st = new Student();
		st.setName("Ken");
		st.setAge(10);
		return st;
	}
	
	@Produces
	@Named("QueryStudent")
	private List<Student> queryAllStudent(){
		List<Student> list = new ArrayList<>();
		Student st = new Student();
		st.setName("Vivin");
		st.setAge(25);
		Student st2 = new Student();
		st2.setName("Iris");
		st2.setAge(42);
		list.add(st);
		list.add(st2);
		return list;
	}
}
