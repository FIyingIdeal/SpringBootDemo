package com.example.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * <p>Title: NormalWebSocketConfig </p>
 * <p>Description: TODO </p>
 * Date: 2017年3月17日 下午4:26:01
 * @author yanchao@hiynn.com
 * @version 1.0 </p> 
 */
@Configuration
@EnableWebSocket
public class NormalWebSocketConfig implements WebSocketConfigurer {
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myHandler(), "/normalwebsocket")
			.addInterceptors(new HandshakeInterceptor())
			.setAllowedOrigins("*")
			.withSockJS();
	}
	
	@Bean
	public WebSocketHandler myHandler() {
		return new MyHandler();
	}

}
