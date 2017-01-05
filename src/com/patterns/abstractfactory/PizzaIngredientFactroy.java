package com.patterns.abstractfactory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public interface PizzaIngredientFactroy {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Meat createMeat();
}
