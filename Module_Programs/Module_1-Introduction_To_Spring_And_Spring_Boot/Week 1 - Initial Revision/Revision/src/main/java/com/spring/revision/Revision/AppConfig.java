package com.spring.revision.Revision;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    Person generatePerson() {
        Person newPerson = new Person("John");
        return newPerson.getPerson();
    }
}
