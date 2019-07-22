package com.example.tickets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.tickets.domain.model.OrderEntityStatus;
import com.example.tickets.domain.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@EnableScheduling
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PaymentService {

	private static final String URL_RANDOM_STATUS = "http://localhost:8080/payment/random";
	private final OrderRepository orderRepository;
	private final RestTemplate restTemplate;

	@Scheduled(initialDelay = 1000, fixedDelay = 60000)
	@Transactional
	public void payment() {
		orderRepository.findFirstByStatusEquals(OrderEntityStatus.PROCESSING).ifPresent(order -> {
			OrderEntityStatus newStatus = restTemplate.getForObject(URL_RANDOM_STATUS, OrderEntityStatus.class);
			orderRepository.changeStatus(order.getId(), newStatus);
			log.debug("Order with id={} change status on {}", order.getId(), newStatus);
		});
	}

}
