package com.myapp.myapp;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record TransactionResponse(
        HttpStatus httpStatus,
        String msg
) {
}
