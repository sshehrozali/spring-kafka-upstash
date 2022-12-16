package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.transaction.KafkaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class TransactionProducerConfig {
    @Bean
    KafkaTransactionManager<Integer, Transaction> kafkaTransactionManager(final ProducerFactory<Integer, Transaction> producerFactory) {
        return new KafkaTransactionManager<>(producerFactory);
    }
}
