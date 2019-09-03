package com.java.algorithm.queue;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by mihir.desai on 1/25/2018.
 */
public class ArrayQueue<T> {
    private int sz = 0; // current number of elements
    private int head = 0; // index of front element
    private int tail = 0;
    private T[] data;
    private static final int SCALE_FACTOR = 2;
    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return sz;
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    /**
     * Add the element to rear end of queue
     * @param e
     * @throws IllegalStateException
     */
    public void enqueue(T e) throws IllegalStateException {
        if(sz == data.length) {
            Collections.rotate(Arrays.asList(data), -head);
            // Reset Head and Tail
            head = 0;
            tail = sz;
            data = Arrays.copyOf(data,sz * SCALE_FACTOR);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        sz++;
    }

    public T first() {
        if(isEmpty()) {
            return null;
        }

        return data[head];
    }

    public T last() {
        if(isEmpty()) {
            return null;
        }

        return data[tail];
    }

    /**
     * Removes the front element of queue
     * @return
     */
    public T dequeue() {
        if(isEmpty()) return null;
        T val = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        sz--;
        return val;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);

        for(int i = 0; i < 20;i++) {
            queue.enqueue(i + 1);
        }
    }
}
