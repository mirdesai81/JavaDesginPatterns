package com.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeCounter {
    //private volatile int counter;

    private AtomicInteger counter = new AtomicInteger();

    public void inc() {
        //counter++;
        counter.incrementAndGet();
    }

    public void dec() {
        //counter--;
        counter.decrementAndGet();
    }

    public int get() {
        //return counter;
        return counter.intValue();
    }
}
