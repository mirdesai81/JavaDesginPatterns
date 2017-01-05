package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Tomato Sauce";

        toppings.add("Shredded cheese");
        toppings.add("Shredded cheddar cheese");
    }

    public void cut(){
        System.out.println("Cutting the pizza in triangle slices");
    }
}
