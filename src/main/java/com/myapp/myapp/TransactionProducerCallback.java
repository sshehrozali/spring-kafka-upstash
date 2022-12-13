package com.myapp.myapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class TransactionProducerCallback implements ListenableFutureCallback<SendResult<Integer, Transaction>> {

    @Override
    public void onFailure(Throwable ex) {
        log.error("Sent Message failed");
    }

    @Override
    public void onSuccess(SendResult<Integer, Transaction> result) {
        if (result != null) {
            log.info("Send Message Success" + result.getProducerRecord().key() + result.getProducerRecord().value());
        }
    }
}
