package com.springBoot.week1Introduction.IntroductionToSpringBoot;

public class UserService {
    private String name;

    public UserService(String name) {
        this.name = name;
    }

    // Instance factory method for bean creation
    public UserService createUserService(String name) {
        return new UserService(name);
    }

    void displayUser() {
        System.out.println("Name: " + name);
    }
}
