package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class VeggiePizza extends Pizza {
    public VeggiePizza() {
        name = "Veggie Pizza";
        dough = "Crust";
        sauce = "Marinara Sauce";
        toppings.add("Onions");
        toppings.add("Cheese");
        toppings.add("Sliced red pepper");
    }
}
