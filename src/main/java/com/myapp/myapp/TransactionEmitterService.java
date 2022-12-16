package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionEmitterService {
    private final TransactionRepository transactionRepository;
    private final TransactionProducer transactionProducer;

    public void processTransaction() throws InterruptedException {
        Transaction t = Transaction.builder()
                .transaction_id("ABC-123")
                .amount(2000)
                .build();
        log.warn("Sending Transaction... " + t);
        transactionProducer.sendTransaction(t);
    }
}
