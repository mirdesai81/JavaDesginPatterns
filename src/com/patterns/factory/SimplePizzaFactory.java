package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if(type.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza();
        } else {
            pizza = new PepperoniPizza();
        }

        return pizza;
    }
}
