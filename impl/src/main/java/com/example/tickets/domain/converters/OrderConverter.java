package com.example.tickets.domain.converters;

import org.springframework.stereotype.Component;

import com.example.tickets.api.v1.dto.Order;
import com.example.tickets.domain.model.OrderEntity;

@Component
public class OrderConverter {

	public Order toDto(OrderEntity order) {
		if (order == null) {
			return null;
		}
		return Order.builder()
				.id(order.getId())
				.routNumber(order.getRoutNumber())
				.dateTime(order.getDateTime())
				.status(order.getStatus().name())
				.build();
	}

}
