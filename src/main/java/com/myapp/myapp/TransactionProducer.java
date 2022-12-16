package com.myapp.myapp;

import jakarta.transaction.TransactionalException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@RequiredArgsConstructor
public class TransactionProducer {
    private final KafkaTemplate kafkaTemplate;
    private final TransactionProducerCallback transactionProducerCallback;

    @Transactional
    public void sendTransaction(Transaction t) throws TransactionalException, InterruptedException {
        ListenableFuture<SendResult<Integer, Transaction>> result = (ListenableFuture<SendResult<Integer, Transaction>>) kafkaTemplate.send("transactions", t.getTransaction_id(), t);
        result.addCallback(transactionProducerCallback);
        Thread.sleep(1000);
    }
}
