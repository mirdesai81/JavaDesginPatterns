package com.patterns.factory;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class PizzaTest {
    public static void main(String[] args) {
       /* PizzaStore store = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = store.orderPizza("veggie");
        System.out.print(pizza);
        pizza = store.orderPizza("pepperoni");
        System.out.print(pizza);*/

        AbstractPizzaStore nyStore = new NYStylePizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.print(pizza);

        AbstractPizzaStore chStore = new ChicagoStylePizzaStore();
        pizza = chStore.orderPizza("veggie");
        System.out.print(pizza);

    }
}
