package com.AliceAndHerBakery.CakeBaker;

import org.springframework.stereotype.Component;

@Component("chocolateSyrup")
public class ChocolateSyrup implements Syrup {
    public String getSyrupType() {
        return "ChocolateSyrup";
    }
}
