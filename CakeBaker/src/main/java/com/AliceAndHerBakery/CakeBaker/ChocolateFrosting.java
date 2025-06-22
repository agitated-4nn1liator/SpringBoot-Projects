package com.AliceAndHerBakery.CakeBaker;

import org.springframework.stereotype.Component;

@Component("chocolateFrosting")
public class ChocolateFrosting implements Frosting {
    public String getFrostingType() {
        return "ChocolateFrosting";
    }
}
