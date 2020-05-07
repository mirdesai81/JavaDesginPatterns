package com.java.algorithm.stack.AnimalShelter;

public class Cat extends Animal {

    public Cat(String n) {
        super(n);
    }

    public String name() {
        return "Cat - " + super.name;
    }
}
