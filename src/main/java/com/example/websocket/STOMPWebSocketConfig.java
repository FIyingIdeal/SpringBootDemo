package com.example.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
//@EnableWebSocket
@EnableWebSocketMessageBroker
public class STOMPWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer/* implements WebSocketConfigurer*/ {

	/*
	 * 这个方法的作用是添加一个服务端点，来接收客户端的连接。
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//设置客户端和服务端建立连接的端口名称，并支持SockJS
		registry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS();
	}
	
	/*
	 * 这个方法的作用是定义消息代理，通俗一点讲就是设置消息连接请求的各种规范信息。
	 * @see org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer#configureMessageBroker(org.springframework.messaging.simp.config.MessageBrokerRegistry)
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//设置客户端接收服务端广播数据的地址前缀
		registry.enableSimpleBroker("/topic");
		//设置客户端往服务端发送数据的地址前缀
		registry.setApplicationDestinationPrefixes("/app");
	}

	/**
	 * 注册webSocketHandler,可以①为特定路径设置Handler；②添加拦截器
	 */
	/*@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		registry.addHandler(myHandler(), "/websocket")		//为'/websocket'添加handler
			.addInterceptors(new HandshakeInterceptor())	//添加‘握手’的拦截器
			//.setHandshakeHandler(handshakeHandlerForJetty())
			.setAllowedOrigins("*")
			.withSockJS();			//设置跨域（spring 4.1.5以上）
		registry.addHandler(myHandler(), "/sockjs/websocket")
			.setAllowedOrigins("*")		//设置跨域（spring 4.1.5以上）
			.withSockJS();				//Enable SockJS
	}*/
	
	/**
	 * 自定义handler
	 * <p>Title: myHandler </p>
	 * <p>Description: TODO </p>
	 * @return
	 */
	/*@Bean
	public WebSocketHandler myHandler() {
		return new MyHandler();
	}*/
	
}
