package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionEmitterService {
    private final TransactionRepository transactionRepository;
    private final TransactionProducer transactionProducer;

    public CustomTransactionResponse processTransaction(NewTransactionRequest newTransactionRequest) throws InterruptedException {
        Transaction t = Transaction.builder()
                .transaction_id("ABC-123")
                .amount(newTransactionRequest.amount())
                .build();
        log.warn("Sending Transaction... " + t);
        transactionProducer.sendTransaction(t);
        log.info("Sent");

        transactionRepository.save(t);

        CustomTransactionResponse customTransactionResponse = CustomTransactionResponse.builder()
                .httpStatus(HttpStatus.OK)
                .msg("Transaction sent successfully")
                .build();
        return customTransactionResponse;
    }
}
