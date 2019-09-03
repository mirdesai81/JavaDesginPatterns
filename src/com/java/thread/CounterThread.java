package com.java.thread;

public class CounterThread implements Runnable {
    private Counter counter;
    public CounterThread(Counter counter) {
        this.counter = counter;
    }


    @Override
    public void run() {
        try {

            System.out.println("Calling - " + Thread.currentThread().getName() + ", Thread state - " + Thread.currentThread().getState());
            if(Thread.currentThread().isInterrupted()) {
             System.out.println(Thread.currentThread().getName() + "is interrupted!!");
            } else {
                for (int i = 0; i < 10; i++) {
                    counter.add(i);
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
