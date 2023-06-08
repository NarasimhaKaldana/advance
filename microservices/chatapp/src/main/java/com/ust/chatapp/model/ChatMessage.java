package com.ust.chatapp.model;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.JsonSerializable;

public abstract class ChatMessage {
	    private String sender;
	    private String content;
		public ChatMessage(String sender, String content) {
			super();
			this.sender = sender;
			this.content = content;
		}
		public String getSender() {
			return sender;
		}
		public void setSender(String sender) {
			this.sender = sender;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		@Bean
	      public MessageConverter converter() {
	    	  return new Jackson2JsonMessageConverter();
	      }
	    // Constructor, getters, and setters
	
}
