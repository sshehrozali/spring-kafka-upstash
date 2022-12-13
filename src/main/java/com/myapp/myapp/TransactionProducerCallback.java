package com.myapp.myapp;

import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class TransactionProducerCallback implements ListenableFutureCallback<SendResult<Integer, Transaction>> {

    @Override
    public void onFailure(Throwable ex) {

    }

    @Override
    public void onSuccess(SendResult<Integer, Transaction> result) {

    }
}
