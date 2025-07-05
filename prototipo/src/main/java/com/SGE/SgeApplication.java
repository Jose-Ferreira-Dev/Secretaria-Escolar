package com.SGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.SGE.repository") // Ajuste para o seu pacote
public class SgeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SgeApplication.class, args);
    }
}
