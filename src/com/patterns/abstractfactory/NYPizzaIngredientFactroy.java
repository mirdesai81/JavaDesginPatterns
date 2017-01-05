package com.patterns.abstractfactory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class NYPizzaIngredientFactroy implements PizzaIngredientFactroy {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new CheddarCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Garlic(), new Onions()};
        return veggies;
    }

    @Override
    public Meat createMeat() {
        return new Pepperoni();
    }
}
