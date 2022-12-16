package com.myapp.myapp;

import lombok.Builder;

@Builder
public record NewTransactionRequest(
        Integer amount
) {
}
