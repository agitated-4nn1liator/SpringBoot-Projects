package com.springBoot.week1Introduction.IntroductionToSpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    Apple getApple() {
        return new Apple();
    }

    @Bean
    UserService getUserService() {
        String name = "John Doe";

        UserService userService = new UserService(name);

        return userService.createUserService(name);
    }
}
