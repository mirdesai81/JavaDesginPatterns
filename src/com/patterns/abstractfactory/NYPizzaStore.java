package com.patterns.abstractfactory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class NYPizzaStore extends PizzaStore {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactroy pizzaIngredientFactroy = new NYPizzaIngredientFactroy();
        if(type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza(pizzaIngredientFactroy);
            pizza.setName("NY Style Cheese Pizza");
        } else {
            pizza = new VeggiePizza(pizzaIngredientFactroy);
            pizza.setName("NY Style Veggie Pizza");
        }

        return  pizza;
    }
}
