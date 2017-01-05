package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        name = "NY Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Tomato Sauce";

        toppings.add("Shredded cheese");
        toppings.add("Onions");
        toppings.add("Green Peppers");
        toppings.add("Mushrooms");
        toppings.add("Eggplant");
    }

    public void cut(){
        System.out.println("Cutting the pizza in triangle slices");
    }
}
