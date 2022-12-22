package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionEmitterService {
    private final TransactionProducer transactionProducer;

    public CustomTransactionResponse processTransaction(NewTransactionRequest newTransactionRequest) throws InterruptedException {
        Transaction t = Transaction.builder()
                .transaction_id(UUID.randomUUID().toString())
                .amount(newTransactionRequest.amount())
                .state(0)   // Default to 0
                .build();

        transactionProducer.sendTransaction(t);
        log.warn("Transaction sent successfully");

        CustomTransactionResponse customTransactionResponse = CustomTransactionResponse.builder()
                .httpStatus(HttpStatus.OK)
                .transactionId(t.getTransaction_id())
                .msg("Transaction sent successfully")
                .build();
        return customTransactionResponse;
    }
}
