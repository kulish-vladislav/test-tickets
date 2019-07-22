package com.example.tickets.api.v1.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Value
public class OrderRequestData {
    @NotNull
    private String routNumber;

    @NotNull
    private LocalDateTime dateTime;
}
