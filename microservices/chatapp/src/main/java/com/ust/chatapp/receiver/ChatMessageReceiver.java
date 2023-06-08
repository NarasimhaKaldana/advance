package com.ust.chatapp.receiver;

 
	import org.springframework.amqp.rabbit.annotation.RabbitListener;
	import org.springframework.stereotype.Component;

import com.ust.chatapp.model.ChatMessage;

	@Component
	public class ChatMessageReceiver {

	    @RabbitListener(queues = "chat.queue")
	    public void receiveChatMessage(ChatMessage message) {
	        System.out.println("Received message: " + message.getContent() + " from " + message.getSender());
	        // Handle the received message, e.g., broadcast it to WebSocket clients or store it in the database
	    }
	

	
}
