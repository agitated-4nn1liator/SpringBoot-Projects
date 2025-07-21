package com.springBoot.week1Introduction.IntroductionToSpringBoot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Apple {
    void eatApple() {
        System.out.println("I am eating an apple");
    }

    @PostConstruct
    void postCreateApple() {
        System.out.println("I am creating an apple before use");
    }

    @PreDestroy
    void preDestroyApple() {
        System.out.println("I am destroying an apple");
    }
}
