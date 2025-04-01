package com.cordingrecipe.scheduledevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 적용
@SpringBootApplication
public class ScheduleDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleDevelopApplication.class, args);
    }

}
