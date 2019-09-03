package com.java.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumerWithSignal {
    private WaitNotifySignal signal;
    private Queue<Integer> values = new LinkedList<>();
    private static final int MAXQUEUE = 5;
    private boolean wasSignalled = false;
    private MonitorObject monitorObject = new MonitorObject();
    private static class MonitorObject {

    }


    public ProducerConsumerWithSignal(WaitNotifySignal signal) {
        this.signal = signal;
    }

    public void produce(Integer value) {


            while (wasSignalled) {
                //signal.doWait();
                doWait();
            }

            System.out.println("Producing value - " + value);
            values.add(value);
            //signal.doNotify();
            doNotify();

    }

    public  Integer consume() {
        while(values.isEmpty()) {
            //signal.doWait();
            doWait();
        }

        Integer value = values.poll();
        System.out.println("Consumeed value - "+value);
        doNotify();
        return value;
    }

    public void doWait() {
        synchronized (monitorObject) {
            // if wasSignalled is false which means notify was not called before wait in that case thread can call wait
            if (!wasSignalled) {
                try {
                    monitorObject.wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            // clear the signal and continue running
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized (monitorObject) {
            wasSignalled = true;
            monitorObject.notify();
        }
    }
}
