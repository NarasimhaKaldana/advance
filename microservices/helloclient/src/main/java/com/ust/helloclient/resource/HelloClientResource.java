package com.ust.helloclient.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/api/client")
public class HelloClientResource {

	@Autowired
	RestTemplate template;
	@GetMapping
	public String callServer() {
		//String url="http://localhost:8094/rest/server";
		String url="http://localhost:8093/rest/billserver";
		String output=template.getForObject(url,String.class);
		return output;
	}
	
	
	
	
	
	

}
