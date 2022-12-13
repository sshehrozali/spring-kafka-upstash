package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionEmitterService {
    private final TransactionRepository transactionRepository;
    private final KafkaProducer kafkaProducer;

    public void processTransaction() {

    }
}
