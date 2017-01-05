package com.patterns.decorator;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class Expresso extends Beverage {
    public Expresso() {
        description = "Expresso";
    }

    public double cost() {

        if(super.getSize() == Size.TALL) {
            return 1.99 ;
        } else if(super.getSize() == Size.GRAANDE) {
            return 2.30 ;
        } else {
            return 2.80 ;
        }
    }
}
