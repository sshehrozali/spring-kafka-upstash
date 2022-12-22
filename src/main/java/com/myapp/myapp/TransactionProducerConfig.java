package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.transaction.KafkaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class TransactionProducerConfig {
    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("transactions-topic")
                .partitions(3)
                .replicas(1)
                .build();
    }
    @Bean(name = "transactionManager")
    KafkaTransactionManager<Integer, Transaction> kafkaTransactionManager(final ProducerFactory<Integer, Transaction> producerFactory) {
        return new KafkaTransactionManager<>(producerFactory);
    }
}
