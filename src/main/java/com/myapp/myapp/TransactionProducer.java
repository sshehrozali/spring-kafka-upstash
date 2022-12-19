package com.myapp.myapp;

import jakarta.transaction.TransactionalException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Properties;

@Component
@RequiredArgsConstructor
public class TransactionProducer {
    private final KafkaTemplate<Integer, Transaction> kafkaTemplate;
    private final TransactionProducerCallback transactionProducerCallback;

    @Transactional
    public void sendTransaction(Transaction t) throws InterruptedException, TransactionException {
        kafkaTemplate.send("transactions-topic", t.getId(), t);
        Thread.sleep(1000);
    }
}
