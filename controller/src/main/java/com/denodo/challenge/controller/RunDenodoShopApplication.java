package com.denodo.challenge.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.denodo.*")
public class RunDenodoShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunDenodoShopApplication.class);
    }
}
