package com.java.thread;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
       /* Counter counter = new Counter();
        Thread thread1 = new Thread(new CounterThread(counter),"Thread-1");
        Thread thread2 = new Thread(new CounterThread(counter),"Thread-2");

        System.out.println("Before Start Calling - " + thread1.getName() + ", Thread state - " + thread1.getState() + " isAlive - "+thread1.isAlive());
        System.out.println("Before Start Calling - " + thread2.getName() + ", Thread state - " + thread2.getState() + " isAlive - "+thread2.isAlive());
        thread1.start();
        thread2.start();

        System.out.println("After Start Calling - " + thread1.getName() + ", Thread state - " + thread1.getState() + " isAlive - "+thread1.isAlive());
        System.out.println("After Start Calling - " + thread2.getName() + ", Thread state - " + thread2.getState() + " isAlive - "+thread2.isAlive());
        try {
            Thread.sleep(100);
            //thread1.interrupt();
            for (int i = 0; i < 5; i++) {
                System.out.println("Counter - " + counter.getCount());
                Thread.sleep(2);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        List<Integer> list = IntStream.range(1,10).boxed().collect(Collectors.toList());
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread writer = new Thread(() -> list.stream().forEach(producerConsumer::produce));
        Thread reader = new Thread(() -> {
            for(int i = 0; i < list.size(); i++) {
                producerConsumer.consume();
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();*/


        /*UnsafeCounter unsafeCounter = new UnsafeCounter();
        Thread first = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                unsafeCounter.inc();
            }
        });
        Thread second = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                unsafeCounter.dec();
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Current counter value: " + unsafeCounter.get());*/


        List<Integer> list = IntStream.range(1,10).boxed().collect(Collectors.toList());
        ProducerConsumerWithSignal producerConsumer = new ProducerConsumerWithSignal(new WaitNotifySignal());
        Thread writer = new Thread(() -> list.stream().forEach(producerConsumer::produce));
        Thread reader = new Thread(() -> {
            for(int i = 0; i < list.size(); i++) {
                producerConsumer.consume();
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();
    }
}
