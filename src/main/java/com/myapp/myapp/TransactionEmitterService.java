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
        kafkaProducer.sendMessages();
    }
}
