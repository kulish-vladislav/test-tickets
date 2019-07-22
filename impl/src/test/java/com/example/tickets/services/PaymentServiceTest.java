package com.example.tickets.services;

import static java.util.Optional.ofNullable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import com.example.tickets.domain.model.OrderEntity;
import com.example.tickets.domain.model.OrderEntityStatus;
import com.example.tickets.domain.repository.OrderRepository;

class PaymentServiceTest {

	private static final String URL_RANDOM_STATUS = "http://localhost:8080/payment/random";

	@Mock
	private OrderRepository repository;
	@Mock
	private RestTemplate restTemplate;
	@InjectMocks
	private PaymentService service;

	@BeforeEach
	void init() {
		initMocks(this);
	}

	@Test
	void payment() {
		//GIVEN
		OrderEntityStatus newStatus = OrderEntityStatus.COMPLETED;
		OrderEntity order = OrderEntity.builder().id(1L).build();

		given(repository.findFirstByStatusEquals(OrderEntityStatus.PROCESSING)).willReturn(ofNullable(order));
		given(restTemplate.getForObject(URL_RANDOM_STATUS, OrderEntityStatus.class)).willReturn(newStatus);

		//WHEN
		service.payment();

		//THEN
		verify(repository).changeStatus(order.getId(), newStatus);
	}
}