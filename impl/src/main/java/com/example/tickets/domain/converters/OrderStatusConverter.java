package com.example.tickets.domain.converters;

import java.util.Arrays;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.tickets.domain.model.OrderEntityStatus;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderEntityStatus, Integer> {

	@Override
	public Integer convertToDatabaseColumn(OrderEntityStatus status) {
		return status.getDbValue();
	}

	@Override
	public OrderEntityStatus convertToEntityAttribute(Integer statusId) {
		return Arrays.stream(OrderEntityStatus.values())
				.filter(status -> status.getDbValue() == statusId)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("There is no statusId like: " + statusId));
	}

}