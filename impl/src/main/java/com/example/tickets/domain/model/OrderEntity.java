package com.example.tickets.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.tickets.domain.converters.OrderStatusConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "orders")
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String routNumber;

	@Column(nullable = false)
	private LocalDateTime dateTime;

	@Convert(converter = OrderStatusConverter.class)
	@Column(name = "status", nullable = false)
	private OrderEntityStatus status;

}


