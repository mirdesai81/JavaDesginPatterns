package com.java.algorithm.queue;

import java.util.Iterator;

/**
 * Created by Mihir.Desai on 3/22/2017.
 */
public class Queue<T> implements Iterable<T>{
    Node first;
    Node last;
    int N;
    private class Node {
        Node next;
        T item;

        public Node( T item,Node next) {
            this.next = next;
            this.item = item;
        }
    }

    public boolean isEmpty() {return N == 0;}
    public int size() {return N;}

    public void enqueue(T item) {
        Node curr = new Node(item,null);

        if(isEmpty()) {
            first = last = curr;
        } else {
            last.next = curr;
            last = curr;
        }

        N++;
    }

    public T last() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return last.item;
    }

    public T first() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return first.item;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String args[]) {
        Queue<String> queue = new Queue<>();
        String[] data = new String[]{"to","be","-","or","to","not","-","-","that","-"};
        for(String s : data) {
            if(!s.equals("-"))
                queue.enqueue(s);
           /* else if(!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }*/
        }

        System.out.println("Size left on queue - "+queue.size());
        System.out.println("First element on queue - "+queue.first());
        System.out.println("Last element on queue - "+queue.last());

        Iterator<String> it = queue.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
