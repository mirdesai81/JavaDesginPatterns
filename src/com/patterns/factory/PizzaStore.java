package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class PizzaStore {
    SimplePizzaFactory _factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this._factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = _factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return  pizza;
    }
}
