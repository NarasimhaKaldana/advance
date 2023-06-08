package com.ust.chatapp;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ChatappApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ChatappApplication.class, args);
//	}
//
//}

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ust.chatapp.receiver.ChatMessageReceiver;

@SpringBootApplication
public class ChatappApplication {
    private static final String QUEUE_NAME = "chat.queue";

    @Bean
    public Queue chatQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                    MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(ChatMessageReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveChatMessage");
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatappApplication.class, args);
    }
}

