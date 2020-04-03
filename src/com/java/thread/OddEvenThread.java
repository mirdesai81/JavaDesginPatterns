package com.java.thread;

import com.java.stdlib.StdOut;

public class OddEvenThread {
    public static final int TOTAL_NUMS = 100;

    public static class OddEvenMonitor {
        public static final boolean ODD_TURN = true;
        public static final boolean EVEN_TURN = false;
        private boolean turn = ODD_TURN;

        public synchronized void waitTurn(boolean oldTurn) {
            while(turn != oldTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    StdOut.println("Interrupted Exception in wait():"+e);
                }
            }
        }

        public synchronized void toggleTurn() {
            turn ^= true;
            notify();
        }
    }

    public static class OddThread extends Thread {
        private final OddEvenMonitor monitor;
        private int capacity;
        public OddThread(OddEvenMonitor monitor,int capacity) {
            this.monitor = monitor;
            this.capacity = capacity;
        }

        @Override
        public void run() {
            for(int i = 1; i <= capacity; i=i+2) {
                monitor.waitTurn(OddEvenMonitor.ODD_TURN);
                System.out.println(" i = "+i);
                monitor.toggleTurn();
            }
        }
    }

    public static class EvenThread extends Thread {
        private final OddEvenMonitor monitor;
        private int capacity;
        public EvenThread(OddEvenMonitor monitor,int capacity) {
            this.monitor = monitor;
            this.capacity = capacity;
        }

        @Override
        public void run() {
            for(int i = 2; i <= capacity; i=i+2) {
                monitor.waitTurn(OddEvenMonitor.EVEN_TURN);
                System.out.println(" i = "+i);
                monitor.toggleTurn();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OddEvenMonitor monitor = new OddEvenMonitor();
        Thread t1 = new OddThread(monitor,TOTAL_NUMS);
        Thread t2 = new EvenThread(monitor,TOTAL_NUMS);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
