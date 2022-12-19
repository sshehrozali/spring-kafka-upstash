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
    private final KafkaTemplate kafkaTemplate;
    private final TransactionProducerCallback transactionProducerCallback;

    @Transactional
    public void sendTransaction(Transaction t) throws InterruptedException, TransactionException {
        Properties producerProps = new Properties();
        producerProps.put("enable.idempotence", "true");
        producerProps.put("transactional.id", "prod-1");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(producerProps);

        kafkaProducer.initTransactions();
        kafkaProducer.beginTransaction();
        kafkaProducer.send(new ProducerRecord<>("transactions-topic", t.getId().toString(), t.toString()));
        Thread.sleep(1000);
    }
}
