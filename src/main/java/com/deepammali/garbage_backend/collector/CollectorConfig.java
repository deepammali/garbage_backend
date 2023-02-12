package com.deepammali.garbage_backend.collector;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollectorConfig {

    @Bean
    CommandLineRunner commandLineRunnerCollector(CollectorRepository repository) {
        return args -> {
            Collector name = new Collector("name", "email", "pass", "cno", "ppurl", "add", "city");
            Collector name1 = new Collector("name1", "email1", "pass1", "cno1", "ppurl1", "add1", "city1");
            repository.saveAll(List.of(name, name1));
        };
    }
}
