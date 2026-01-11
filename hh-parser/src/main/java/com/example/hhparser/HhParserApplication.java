package com.example.hhparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HhParserApplication {
    public static void main(String[] args) {
        SpringApplication.run(HhParserApplication.class, args);
    }
}
