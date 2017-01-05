package com.patterns.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihir.Desai on 2/18/2016.
 */
abstract public class Pizza {
    String dough;
    String name;
    String sauce;
    List<String> toppings = new ArrayList<String>();

    public void prepare() {
        System.out.println("Preparing: "+name);
    }

    public void bake() {
        System.out.println("Baking:: "+name);
    }

    public void cut() {
        System.out.println("Cutting: "+name);
    }

    public void box() {
        System.out.println("Boxing: "+name);
    }

    public String toString() {
        // code to display pizza name and ingredients
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        for (String topping : toppings) {
            display.append(topping + "\n");
        }
        return display.toString();
    }



    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }
}
