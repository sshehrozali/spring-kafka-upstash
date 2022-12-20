package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final TransactionProducerCallback transactionProducerCallback;

    public void sendTransaction(Transaction t) {
        kafkaTemplate.send("transactions-topic", t);
    }
}
