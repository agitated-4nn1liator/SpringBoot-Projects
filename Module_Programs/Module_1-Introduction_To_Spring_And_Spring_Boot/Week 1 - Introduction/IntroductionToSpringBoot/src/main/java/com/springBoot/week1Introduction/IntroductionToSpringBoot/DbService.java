package com.springBoot.week1Introduction.IntroductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    final private DB db;

    @Autowired
    private Environment env;

    public DbService(DB db) {
        this.db = db;
    }

    String getData() {
        System.out.println(env.getProperty("app.message"));
        return db.getData();
    }
}
