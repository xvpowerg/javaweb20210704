package tw.com.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("test")
public class TestRestful {
	//@GET 查資料
	//@POST新增
	//@PATH 修該改
	//@DELETE 刪除
	@GET
	public String testHello(
			@QueryParam("name")String myName,
			@QueryParam("count")int myCount) {
		System.out.println(myName+":"+myCount);
		return "Hello!!";
	}
	
	@GET
	@Path("all")
	public String selectAll() {
				return "Ken,Vivin,Lindy";
	  }
	
	
}
