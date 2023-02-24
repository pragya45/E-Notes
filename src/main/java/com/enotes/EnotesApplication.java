package com.enotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EnotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnotesApplication.class, args);
    }

}
