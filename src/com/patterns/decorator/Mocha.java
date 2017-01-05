package com.patterns.decorator;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this._beverage = beverage;
    }

    public String getDescription() {
        return _beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        double cost;
        if(_beverage.getSize() == Size.TALL) {
            cost =  .20 + _beverage.cost();
        } else if(_beverage.getSize()== Size.GRAANDE) {
            cost =  .30 + _beverage.cost();
        } else {
            cost = .40 + _beverage.cost();
        }

        System.out.println("Cost:"+cost);
        return cost;
    }

}
