package com.example.drivenow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.controller", "com.example.service", "com.example.exception", "com.example.config"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class DriveNowApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriveNowApplication.class, args);
    }

}
