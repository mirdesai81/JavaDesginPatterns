package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza() {
        name = "Chicago Style Veggie Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded cheese");
        toppings.add("Onions");
        toppings.add("Green Peppers");
        toppings.add("Mushrooms");
        toppings.add("Eggplant");
    }

    public void cut(){
        System.out.println("Cutting the pizza in square slices");
    }
}
