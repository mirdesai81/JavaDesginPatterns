package com.java.algorithm.queue;

/**
 * Created by mihir.desai on 1/25/2018.
 */
public class ArrayQueue<T> {
    private int sz = 0; // current number of elements
    private int f = 0; // index of front element
    private T[] data;

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
            throw new IllegalStateException("Queue is full");
        }

        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    public T first() {
        if(isEmpty()) {
            return null;
        }

        return data[f];
    }

    /**
     * Removes the front element of queue
     * @return
     */
    public T dequeue() {
        if(isEmpty()) return null;
        T val = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return val;
    }
}
