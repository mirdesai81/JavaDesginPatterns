package com.patterns.abstractfactory;

public class VeggiePizza extends Pizza {
    PizzaIngredientFactroy factory;

    public VeggiePizza(PizzaIngredientFactroy factory) {
        this.factory = factory;
    }

    public void prepare() {
        System.out.println("Preparing : " +name);
        dough = factory.createDough();
        sauce = factory.createSauce();
        cheese = factory.createCheese();
        veggies = factory.createVeggies();
    }



}