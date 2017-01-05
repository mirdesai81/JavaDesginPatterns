package com.patterns.abstractfactory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactroy factory;

    public CheesePizza(PizzaIngredientFactroy factory) {
        this.factory = factory;
    }

    public void prepare() {
        System.out.println("Preparing : " +name);
        dough = factory.createDough();
        sauce = factory.createSauce();
        cheese = factory.createCheese();
    }



}
