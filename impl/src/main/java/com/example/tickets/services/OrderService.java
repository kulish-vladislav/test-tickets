package com.example.tickets.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tickets.api.v1.dto.Order;
import com.example.tickets.api.v1.dto.OrderRequestData;
import com.example.tickets.domain.converters.OrderConverter;
import com.example.tickets.domain.model.OrderEntity;
import com.example.tickets.domain.model.OrderEntityStatus;
import com.example.tickets.domain.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OrderService {

	private final OrderRepository repository;
	private final OrderConverter converter;

	@Transactional(readOnly = true)
	public Optional<String> getStatus(long id) {
		return getById(id).map(Order::getStatus);
	}

	@Transactional
	public long create(OrderRequestData orderRequestData) {
		OrderEntity newOrder = OrderEntity.builder()
				.routNumber(orderRequestData.getRoutNumber())
				.dateTime(orderRequestData.getDateTime())
				.status(OrderEntityStatus.PROCESSING)
				.build();
		return repository.save(newOrder).getId();
	}

	private Optional<Order> getById(long id) {
		return repository.findById(id).map(converter::toDto);
	}
}
