package com.patterns.decorator;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    public double cost() {
        if(super.getSize() == Size.TALL) {
            return .99 ;
        } else if(super.getSize() == Size.GRAANDE) {
            return 1.30 ;
        } else {
            return 1.80 ;
        }

    }
}
