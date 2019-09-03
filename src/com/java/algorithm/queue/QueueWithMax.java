package com.java.algorithm.queue;

import java.util.*;
import java.util.Queue;

public class QueueWithMax {
    private Deque<Integer> entries = new LinkedList<>();
    private Deque<Integer> candidatesForMax = new LinkedList<>();

    public void enqueue(Integer x) {
        entries.addLast(x);
        // keep removing elements from candidatesForMax untill it is greater or equal to x (enqueued element)

        // dequeue behaves as stack for enqueue
        while(!candidatesForMax.isEmpty()) {
            if(candidatesForMax.peekLast().compareTo(x) >= 0) {
                break;
            }

            candidatesForMax.removeLast();
        }

        candidatesForMax.addLast(x);
    }

    public Integer dequeue() {
        if(!entries.isEmpty()) {
            Integer curr = entries.removeFirst();
            // dequeue behaves as queue for dequeue operation
            if(curr.compareTo(candidatesForMax.peekFirst()) == 0) {
                candidatesForMax.removeFirst();
            }

            return curr;
        }

        throw new NoSuchElementException("Called dequeue() on empty queue.");
    }

    public Integer max() {
        if(!candidatesForMax.isEmpty()) {
            return candidatesForMax.peek();
        }

        throw new NoSuchElementException("No Such element");
    }

    public static void main(String[] args) {
        QueueWithMax q = new QueueWithMax();
        q.enqueue(3);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(2);
        q.enqueue(0);
        q.enqueue(1);

        q.dequeue();
        q.dequeue();

        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(4);

        System.out.println(q.max());

    }
}
