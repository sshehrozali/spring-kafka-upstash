package com.myapp.myapp;

import lombok.Builder;

@Builder
public record NewTransactionRequest(
        String amount
) {
}
