package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionEmitter {
    private final KafkaProducer kafkaProducer;
}
