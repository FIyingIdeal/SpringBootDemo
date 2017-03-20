package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.example.domain.websocket.Greeting;
import com.example.domain.websocket.HelloMessage;
/**
 * STOMP WebSocket的Controller
 * <p>Title: STOMPWebSocketController </p>
 * <p>Description: TODO </p>
 * Date: 2017年3月17日 下午4:14:15
 * @author yanchao@hiynn.com
 * @version 1.0 </p>
 */
@Controller
public class STOMPWebSocketController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/hello")
	//@SendTo("/topic/greetings")//默认将消息发送到/topic/hello,使用@SendTo可以将该地址覆盖
	public Greeting greeting(HelloMessage message) throws InterruptedException {
		Thread.sleep(3000);
		return new Greeting("Hello, " + message.getName());
	}
	
	@Scheduled(fixedRate = 5000)
	public void trigger() {
		HelloMessage message = new HelloMessage();
		message.setName("zhangsan");
		this.template.convertAndSend("/topic/greetings", message);
	}

}
