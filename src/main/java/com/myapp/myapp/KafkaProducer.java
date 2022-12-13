package com.myapp.myapp;

import jakarta.transaction.Transactional;
import jakarta.transaction.TransactionalException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Bean
    @Transactional
    public void sendMessages() throws TransactionalException, InterruptedException {

    }
}
