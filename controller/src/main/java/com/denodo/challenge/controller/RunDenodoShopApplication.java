package com.denodo.challenge.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.denodo.*"})
@EntityScan(basePackages = {"com.denodo.*"})
@EnableJpaRepositories(basePackages = {"com.denodo.*"})
public class RunDenodoShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunDenodoShopApplication.class);
    }
}