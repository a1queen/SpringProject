package com.example.demo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableFeignClients(basePackages = "com.example.proxies")

@EnableJpaRepositories("com.example.repositories")
@ComponentScan({ "com.example.*" })
@EntityScan({ "com.example.model" })
public class ProjectConfig {

}
