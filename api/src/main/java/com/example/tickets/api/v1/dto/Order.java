package com.example.tickets.api.v1.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Order {

	private Long id;

	@NotNull
	private String routNumber;

	@NotNull
	private LocalDateTime dateTime;

	private String status;
}
