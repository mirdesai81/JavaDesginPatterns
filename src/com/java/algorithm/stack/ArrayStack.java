package com.java.algorithm.stack;

public class ArrayStack<T> {
    private T[] items;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 5;
    public ArrayStack() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int capacity) {
        items = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return this.items.length == size;
    }

    public void push(T v) {
        if(isFull()) throw new IllegalStateException("Stack is full");

        items[size++] = v;
    }

    public T peek() {

        if(isEmpty()) throw new IllegalStateException("Stack is empty");
        return items[size - 1];
    }

    public T pop() {

        if(isEmpty()) throw new IllegalStateException("Stack is empty");

        T item = items[size - 1];
        items[size - 1] = null;
        size--;

        return item;
    }
}
