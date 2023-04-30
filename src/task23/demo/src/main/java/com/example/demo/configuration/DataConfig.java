package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories("com.example.demo.repository")
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
public class DataConfig {
}
