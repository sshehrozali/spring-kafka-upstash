package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@RequiredArgsConstructor
public class MyappApplication {

	private final TransactionEmitterService transactionEmitterService;

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	@Bean
	public NewTopic newTopic() {
		return TopicBuilder.name("transactions-topic")
				.partitions(3)
				.replicas(1)
				.build();
	}

}
