package com.java.algorithm;

import java.util.Iterator;

/**
 * Created by Mihir.Desai on 3/22/2017.
 */
public class Bag<T> implements Iterable<T> {
    private Node first;
    int N = 0;
    private class Node {
        T item;
        Node next;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
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

        Bag<Integer> bag = new Bag<Integer>();
        int[] data = new int[]{2,4,4,4,5,5,7,9};
        int sum = 0;


        for(int i = 0; i< data.length;i++) {
            bag.add(data[i]);
            sum += data[i];
        }

        double mean = sum/data.length;
        double sumOfDeviation = 0;

        Iterator<Integer> it = bag.iterator();
        while(it.hasNext()) {
            int val = it.next();
            sumOfDeviation += Math.abs((val - mean) * (val - mean));
        }

        double variance = sumOfDeviation/data.length;

        System.out.println("Mean - "+mean);
        System.out.println("Variance - "+variance);
        System.out.println("Standard Deviation - " + Math.sqrt(variance));



    }
}
