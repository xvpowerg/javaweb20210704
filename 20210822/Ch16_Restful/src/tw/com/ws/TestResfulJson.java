package tw.com.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("testJson")
//@Produces(MediaType.APPLICATION_JSON) 輸出成Json檔
@Produces(MediaType.APPLICATION_JSON)
public class TestResfulJson {
	//orderId:\\d+ 路徑後可以是1數字或多個數字
	@GET
	@Path("{orderId:\\d+}")	
	public String findById(@PathParam("orderId") int id) {
		System.out.println("id:"+id);
		return "{\"id\":"+id+"}";
	}
}
