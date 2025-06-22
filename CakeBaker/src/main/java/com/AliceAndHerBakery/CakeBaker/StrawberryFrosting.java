package com.AliceAndHerBakery.CakeBaker;

import org.springframework.stereotype.Component;

@Component("strawberryFrosting")
public class StrawberryFrosting implements Frosting {
    public String getFrostingType() {
        return "StrawberryFrosting";
    }
}
