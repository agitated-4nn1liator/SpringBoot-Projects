package com.spring.revision.Revision;

public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return new Person("John");
    }

    public void displayName() {
        System.out.println(name);
    }
}
