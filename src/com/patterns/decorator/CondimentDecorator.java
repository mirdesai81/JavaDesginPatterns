package com.patterns.decorator;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public abstract class CondimentDecorator extends Beverage {
    public Beverage _beverage;
    public abstract String getDescription();

    public Size getSize() {
        return _beverage.getSize();
    }
}
