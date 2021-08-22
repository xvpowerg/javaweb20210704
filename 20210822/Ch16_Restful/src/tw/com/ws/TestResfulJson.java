package tw.com.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("testJson")
//@Produces(MediaType.APPLICATION_JSON) ��X��Json��
@Produces(MediaType.APPLICATION_JSON)
public class TestResfulJson {
	//orderId:\\d+ ���|��i�H�O1�Ʀr�Φh�ӼƦr
	@GET
	@Path("{orderId:\\d+}")	
	public String findById(@PathParam("orderId") int id) {
		System.out.println("id:"+id);
		return "{\"id\":"+id+"}";
	}
}
