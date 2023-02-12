package com.deepammali.garbage_backend.customer;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunnerCustomer(CustomerRepository repository) {

        return args -> {
            Customer a1 = new Customer("name", "email", "pass", "cno", "ppurl", "add", "city");
            Customer a2 = new Customer("name1", "email1", "pass1", "cno1", "ppurl1", "add1", "city1");
            repository.saveAll(List.of(a1, a2));
        };

    }
}
