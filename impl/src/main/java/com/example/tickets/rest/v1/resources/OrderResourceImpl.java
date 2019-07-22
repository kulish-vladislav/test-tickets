package com.example.tickets.rest.v1.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.tickets.api.v1.dto.OrderRequestData;
import com.example.tickets.api.v1.resources.OrderResource;
import com.example.tickets.services.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OrderResourceImpl implements OrderResource {

	private final OrderService service;

	public String getStatus(long id) {
		return service.getStatus(id).orElse(null);
	}

	public long create(OrderRequestData order) {
		return service.create(order);
	}
}
