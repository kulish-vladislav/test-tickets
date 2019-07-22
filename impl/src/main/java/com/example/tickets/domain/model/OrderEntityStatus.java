package com.example.tickets.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrderEntityStatus {
    PROCESSING(1),
    ERROR(2),
    COMPLETED(3);

    @Getter
    private final int dbValue;
}
