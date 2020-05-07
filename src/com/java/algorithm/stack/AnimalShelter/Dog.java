package com.java.algorithm.stack.AnimalShelter;

public class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }

    public String name() {
        return "Dog - " + super.name;
    }
}
