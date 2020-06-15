package com.devesh.mailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class MailsenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailsenderApplication.class, args);
	}
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(50);
		executor.setMaxPoolSize(150);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("mailsender");
		executor.initialize();
		return executor;
	}
}
