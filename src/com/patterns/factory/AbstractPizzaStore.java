package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
abstract public class AbstractPizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return  pizza;
    }

    abstract Pizza createPizza(String type);
}
