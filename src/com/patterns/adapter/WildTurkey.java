package com.patterns.adapter;

/**
 * Created by Mihir.Desai on 2/22/2016.
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble!!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying short distance!!");
    }
}
