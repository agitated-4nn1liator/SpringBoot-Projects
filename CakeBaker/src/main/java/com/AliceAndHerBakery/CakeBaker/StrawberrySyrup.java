package com.AliceAndHerBakery.CakeBaker;

import org.springframework.stereotype.Component;

@Component("strawberrySyrup")
public class StrawberrySyrup implements Syrup {
    public String getSyrupType() {
        return "StrawberrySyrup";
    }
}
