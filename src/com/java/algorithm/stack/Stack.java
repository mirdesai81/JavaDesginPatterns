package com.java.algorithm.stack;

import java.util.EmptyStackException;

public class Stack {
    int size = 0;
    Node top;
    Node bottom;
    int capacity;
    public Stack() {
        this(16);
    }

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean push(int v) {
        if(isFull()) return false;
        Node n = new Node(v);
        ++size;
        if(size == 1) bottom = n;
        join(n,top);
        top = n;
        return true;
    }

    private void join(Node above,Node below) {
        if(above != null) above.below = below;
        if(below != null) below.above = above;
    }

    public int pop() {
        if(isEmpty()) throw new EmptyStackException();
        int v = top.value;
        top = top.below;
        --size;
        return v;
    }

    public int peek() {
        if(isEmpty()) throw new EmptyStackException();
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int removeBottom() {
        if(isEmpty()) throw new EmptyStackException();
        int v = bottom.value;
        --size;
        bottom = bottom.above;
        return v;
    }

}
