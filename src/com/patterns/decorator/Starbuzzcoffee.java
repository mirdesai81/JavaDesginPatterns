package com.patterns.decorator;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
public class Starbuzzcoffee {

     public static void main(String[] args) {
         Beverage beverage = new Expresso();
         beverage.setSize(Beverage.Size.TALL);
         System.out.println("Description: "+beverage.getDescription()+" , Cost: $"+beverage.cost());

         Beverage beverage1 = new HouseBlend();
         beverage1.setSize(Beverage.Size.GRAANDE);
         beverage1 = new Mocha(beverage1);
         beverage1 = new Mocha(beverage1);

         System.out.println("Description: "+beverage1.getDescription()+" , Cost: $"+beverage1.cost());

     }
}
