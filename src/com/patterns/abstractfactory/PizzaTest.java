package com.patterns.abstractfactory;



/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class PizzaTest {
    public static void main(String[] args) {


        PizzaStore nyStore = new NYPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.print(pizza);

        PizzaStore chStore = new ChicagoPizzaStore();
        pizza = chStore.orderPizza("veggie");
        System.out.print(pizza);

    }
}
