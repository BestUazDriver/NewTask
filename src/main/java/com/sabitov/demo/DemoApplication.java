package com.sabitov.demo;

import com.sabitov.demo.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Bean
    public CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> System.out.println(accountRepository.findAll());
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
