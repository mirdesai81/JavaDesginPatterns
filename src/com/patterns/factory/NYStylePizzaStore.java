package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class NYStylePizzaStore extends AbstractPizzaStore {
    @Override
    Pizza createPizza(String type) {

        if(type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else {
            return new NYStyleVeggiePizza();
        }

    }
}
