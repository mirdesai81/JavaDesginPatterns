package com.patterns.decorator;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        this._beverage = beverage;
    }

    @Override
    public String getDescription() {
        return _beverage.getDescription() + ", SoyMilk";
    }

    @Override
    public double cost() {
        return _beverage.cost() + 0.40;
    }
}
