package com.patterns.abstractfactory;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactroy {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MorzerellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Garlic(), new Onions(), new GreenPepper()};
        return veggies;
    }

    @Override
    public Meat createMeat() {
        return null;
    }
}
