package tw.com.wsok;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoServer {
	//@OnMessage �����Ȥ�ݪ��T��
	//����k��return �i�����^�ǵ��Ȥ��
	@OnMessage
	public String message(String msg) {
		String upmsg = msg.toUpperCase();
		return "WebSocket!"+upmsg;
	}
}
