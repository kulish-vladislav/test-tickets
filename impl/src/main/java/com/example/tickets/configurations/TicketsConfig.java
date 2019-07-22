package com.example.tickets.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TicketsConfig {
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
