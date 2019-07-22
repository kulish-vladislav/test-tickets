package com.example.tickets.rest.v1.resources;

import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tickets.domain.model.OrderEntityStatus;

@RestController
@RequestMapping("/payment")
public class PaymentGatewayResource {

	@GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderEntityStatus paymentRequest() {
		OrderEntityStatus[] statuses = OrderEntityStatus.values();
		return statuses[new Random().nextInt(statuses.length)];
	}
}
