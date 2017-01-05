package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded cheese");
    }

    public void cut(){
      System.out.println("Cutting the pizza in square slices");
    }
}
