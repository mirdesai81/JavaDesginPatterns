package com.patterns.decorator;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public abstract class Beverage {
    public enum Size{TALL,GRAANDE,VENTI};

    Size size = Size.TALL;

    String description = "Unknown beverage";
    public abstract double cost();

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
