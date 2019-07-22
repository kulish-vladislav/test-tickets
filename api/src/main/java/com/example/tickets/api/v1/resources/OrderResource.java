package com.example.tickets.api.v1.resources;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tickets.api.v1.dto.OrderRequestData;

@RequestMapping("/tickets")
public interface OrderResource {

	@GetMapping(value = "/{id}/check", produces = MediaType.APPLICATION_JSON_VALUE)
	String getStatus(@NotNull @PathVariable("id") long id);

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	long create(@NotNull @Valid @RequestBody OrderRequestData application);

}
