package com.ust.rabbitmq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessagingConfig {
//      public static final String QUEUE = "ust_queue";
//      public static final String EXCHANGE = "ust_exchange";
//      public static final String ROUTING_KEY = "ust_routingkey";
	
	
	
	@Value("${yst.rabbitmq.queue}")
	String queueName;
	@Value("${yst.rabbitmq.exchange}")
	String exchange;
	@Value("${yst.rabbitmq.routingkey}")
	String routingkey;
      
      @Bean
      public Queue queue() {
    	  return new Queue(queueName);
      }
      @Bean
      public TopicExchange exchange() {
    	  return new TopicExchange(exchange);
      }
      
      @Bean
      public Binding binding(Queue queue,TopicExchange exchange) {
    	  return BindingBuilder.bind(queue).to(exchange).with(routingkey);
      }
      
	
	@Bean
      public MessageConverter converter() {
    	  return new Jackson2JsonMessageConverter();
      }
      @Bean // when @Bean is there spring container will call those methods 
      public AmqpTemplate template(ConnectionFactory connectionFactory) {
    	  final RabbitTemplate template=new RabbitTemplate(connectionFactory);
    			  template.setMessageConverter(converter());
    	  return template;
      }
}
