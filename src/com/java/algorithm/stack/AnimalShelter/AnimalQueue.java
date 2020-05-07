package com.java.algorithm.stack.AnimalShelter;

import com.java.stdlib.StdOut;

import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        ++order;
        if(a instanceof Dog) dogs.addLast((Dog) a);
        else if(a instanceof Cat) cats.addLast((Cat) a);
    }

    public Animal dequeueAny() {
        if(dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        return dog.isOlderThan(cat) ? dequeueDog() : dequeueCat();
    }

    public Dog dequeueDog() {
        return dogs.isEmpty() ? null : dogs.poll();
    }

    public Cat dequeueCat() {

        return cats.isEmpty() ? null : cats.poll();
    }

    public int size() {
        return dogs.size() + cats.size();
    }

    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Callie"));
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Dog("Fido"));
        animals.enqueue(new Dog("Dora"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Dog("Dobo"));
        animals.enqueue(new Cat("Copa"));

        StdOut.println(animals.dequeueAny().name());
        StdOut.println(animals.dequeueAny().name());
        StdOut.println(animals.dequeueAny().name());

        StdOut.println("Enqueue Again");

        animals.enqueue(new Dog("Dapa"));
        animals.enqueue(new Cat("Kilo"));

        while (animals.size() != 0) {
            StdOut.println(animals.dequeueAny().name());
        }
    }
}
