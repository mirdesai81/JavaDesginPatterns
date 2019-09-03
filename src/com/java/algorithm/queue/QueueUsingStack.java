package com.java.algorithm.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> enq = new Stack<>();
    Stack<Integer> deq = new Stack<>();

    public void enqueue(Integer x) {
        enq.push(x);
    }

    public boolean isEmpty() {
        return enq.isEmpty() && deq.isEmpty();
    }

    public Integer dequeue() {
        if(deq.isEmpty()) {
            while(!enq.isEmpty()) {
                // pop all enq elements and store in deq
                deq.push(enq.pop());
            }
        }

        if(!deq.isEmpty()) {
            return deq.pop();
        }

        throw new NoSuchElementException("Cannot pop empty queue");
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        for(int i = 0 ; i < 5;i++) {
            queue.enqueue(i+1);
        }

        for(int i = 0; i < 3;i++) {
            if(i == 2) {
                System.out.print(queue.dequeue());
            } else
            System.out.print(queue.dequeue() + ",");
        }

        for (int i = 0; i < 5; i++) {
            queue.enqueue((i + 1) * 10);
        }

        System.out.println();
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + ",");
        }
    }

}
