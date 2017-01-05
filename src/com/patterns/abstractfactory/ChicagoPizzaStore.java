package com.patterns.abstractfactory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class ChicagoPizzaStore extends PizzaStore {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactroy pizzaIngredientFactroy = new ChicagoPizzaIngredientFactory();
        if(type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza(pizzaIngredientFactroy);
            pizza.setName("Chicago Style Cheese Pizza");
        } else {
            pizza = new VeggiePizza(pizzaIngredientFactroy);
            pizza.setName("Chicago Style Veggie Pizza");
        }

        return  pizza;
    }
}
