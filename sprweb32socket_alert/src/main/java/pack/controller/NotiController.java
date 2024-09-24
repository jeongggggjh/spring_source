package pack.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import pack.model.MyNotification;

@Controller
public class NotiController {
	
	@MessageMapping("/friend-request")
	@SendTo("/topic/notifications")
	public MyNotification friendRequest(String fromUser) {
		if(fromUser == null || fromUser.trim().isEmpty()) {
			fromUser = "Mainoo";
		}
		return new MyNotification("[친구요청]", fromUser + "님이 친구 요청 보냄");
	}
	
	@MessageMapping("/comment")
	@SendTo("/topic/notifications")
	public MyNotification comment(String fromUser) {
		if(fromUser == null || fromUser.trim().isEmpty()) {
			fromUser = "Rashford";
		}
		return new MyNotification("[댓글]", fromUser + "님이 게시물에 댓글 남김");
	}
	
	@MessageMapping("/like")
	@SendTo("/topic/notifications")
	public MyNotification like(String fromUser) {
		if(fromUser == null || fromUser.trim().isEmpty()) {
			fromUser = "Shaw";
		}
		return new MyNotification("[좋아요]", fromUser + "님이 게시물에 좋아요 남김");
	}
}
