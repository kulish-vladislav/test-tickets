package com.example.tickets.services;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.tickets.api.v1.dto.Order;
import com.example.tickets.api.v1.dto.OrderRequestData;
import com.example.tickets.domain.converters.OrderConverter;
import com.example.tickets.domain.model.OrderEntity;
import com.example.tickets.domain.model.OrderEntityStatus;
import com.example.tickets.domain.repository.OrderRepository;

class OrderServiceTest {

	@Mock
	private OrderRepository repository;
	@Mock
	private OrderConverter converter;

	@InjectMocks
	private OrderService service;

	@BeforeEach
	void init() {
		initMocks(this);
	}

	@Test
	void getStatus() {
		//GIVEN
		long id = 1L;
		String expected = "status";
		OrderEntity order = mock(OrderEntity.class);
		Order orderDto = Order.builder().status(expected).build();
		given(repository.findById(id)).willReturn(ofNullable(order));
		given(converter.toDto(order)).willReturn(orderDto);

		//WHEN
		String actual = service.getStatus(id).get();

		//THEN
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void create() {
		//GIVEN
		long expected = 1L;
		LocalDateTime dateTime = LocalDateTime.now();
		OrderRequestData requestData = new OrderRequestData("route", dateTime);
		OrderEntity newOrder = OrderEntity.builder()
				.routNumber("route")
				.dateTime(dateTime)
				.status(OrderEntityStatus.PROCESSING)
				.build();
		OrderEntity order = OrderEntity.builder().id(expected).build();
		given(repository.save(newOrder)).willReturn(order);

		//WHEN
		long actual = service.create(requestData);

		//THEN
		assertThat(actual).isEqualTo(expected);
	}
}