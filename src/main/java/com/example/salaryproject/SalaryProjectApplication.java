package com.example.salaryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SalaryProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalaryProjectApplication.class, args);
    }

}
