package com.patterns.abstractfactory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
abstract public class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return  pizza;
    }

    abstract public Pizza createPizza(String type);

}
