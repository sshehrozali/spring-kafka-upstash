package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TransactionProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final TransactionProducerCallback transactionProducerCallback;

    @Transactional
    public void sendTransaction(Transaction t) throws InterruptedException, TransactionException {
        kafkaTemplate.send("transactions-topic", t);
        Thread.sleep(1000);
    }
}
