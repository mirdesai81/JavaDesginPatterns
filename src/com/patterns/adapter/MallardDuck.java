package com.patterns.adapter;

/**
 * Created by Mihir.Desai on 2/22/2016.
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack!!");
    }

    @Override
    public void fly() {
        System.out.println("Fly!!");
    }
}
