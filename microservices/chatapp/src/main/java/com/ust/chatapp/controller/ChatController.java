package com.ust.chatapp.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.chatapp.model.ChatMessage;

@RestController
public class ChatController {

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public ChatController(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/chat")
    public void sendChatMessage(@RequestBody ChatMessage message) {
        rabbitTemplate.convertAndSend("chat.queue", message);
    }
}

