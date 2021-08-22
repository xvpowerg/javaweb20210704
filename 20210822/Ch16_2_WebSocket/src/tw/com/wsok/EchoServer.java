package tw.com.wsok;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoServer {
	//@OnMessage 接收客戶端的訊息
	//此方法的return 可直接回傳給客戶端
	@OnMessage
	public String message(String msg) {
		String upmsg = msg.toUpperCase();
		return "WebSocket!"+upmsg;
	}
}
