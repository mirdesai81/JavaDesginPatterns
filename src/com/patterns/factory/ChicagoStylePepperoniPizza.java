package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class ChicagoStylePepperoniPizza extends Pizza {

    public ChicagoStylePepperoniPizza() {
        name = "Chicago Style Pepperoni Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded cheese");
        toppings.add("Black Olives");
    }

    public void cut(){
        System.out.println("Cutting the pizza in square slices");
    }
}