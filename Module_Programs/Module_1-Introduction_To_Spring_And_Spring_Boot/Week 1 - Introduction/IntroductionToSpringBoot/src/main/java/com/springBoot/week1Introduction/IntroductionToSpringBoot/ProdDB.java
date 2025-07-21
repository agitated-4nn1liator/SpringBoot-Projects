package com.springBoot.week1Introduction.IntroductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.environment", havingValue = "production")
public class ProdDB implements DB {
    public String getData() {
        return "ProdData";
    }
}
