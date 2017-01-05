package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Thin Crust";
        sauce = "Marinara Sauce";
        toppings.add("Pepperoni");
        toppings.add("Cheese");
    }
}
