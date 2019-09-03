package com.java.thread;

public class WaitNotifySignal {

    private static class MonitorObject {

    }

    private MonitorObject monitorObject = new MonitorObject();
    private boolean wasSignalled = false;


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


