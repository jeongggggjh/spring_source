package pack;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	
	@MessageMapping("/messages") // /app/message로 수신된 메세지를 처리. 라우팅할 때 /app은 적지않음.
	// 처리된 메세지는 "/topic/messages" 로 브로드 캐스팅 됨
	@SendTo("/topic/messages")
	public String sendMessage(String message) {
		return message; // 받은 메세지 그대로 반환. 자동으로 /topic/messages 경로를 구독(subscribe)하고 있는 모든 클라이언트에 전송
	}
}
