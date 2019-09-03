package com.java.thread;

public class Counter {
    long count = 0;

    public synchronized void add(long value) {
        count += value;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
