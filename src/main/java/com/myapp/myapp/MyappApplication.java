package com.myapp.myapp;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Properties;

@SpringBootApplication
public class MyappApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}
}
