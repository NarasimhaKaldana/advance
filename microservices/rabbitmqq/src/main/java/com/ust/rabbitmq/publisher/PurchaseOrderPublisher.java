package com.ust.rabbitmq.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rabbitmq.config.MessagingConfig;
import com.ust.rabbitmq.model.OrderStatus;
import com.ust.rabbitmq.model.PurchaseOrder;

@RestController
@RequestMapping("/order")
public class PurchaseOrderPublisher {
	
	@Value("${yst.rabbitmq.queue}")
	String queueName;
	@Value("${yst.rabbitmq.exchange}")
	String exchange;
	@Value("${yst.rabbitmq.routingkey}")
	String routingkey;
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/{customerName}")
	public String bookOrder(@RequestBody PurchaseOrder order, @PathVariable String customerName) {
		order.setOrderId(UUID.randomUUID().toString());            
		//other service calls
		
		OrderStatus orderStatus = new OrderStatus(order, "ACCEPTED", "oredr placed successfully by " + customerName);
//		template.convertAndSend(MessagingConfig.exchange,MessagingConfig.routingkey,orderStatus);
		template.convertAndSend(exchange,routingkey,orderStatus);
		return "success";
	}

}
