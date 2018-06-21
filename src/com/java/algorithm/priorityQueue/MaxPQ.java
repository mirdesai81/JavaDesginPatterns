package com.java.algorithm.priorityQueue;

import com.java.stdlib.StdIn;
import com.java.stdlib.StdOut;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;
    private Comparator<Key> comparator;

    public MaxPQ() {
        this(1);
    }

    public MaxPQ(int capacity) {
        pq = (Key[]) new Object[capacity + 1];
        n = 0;
    }

    public MaxPQ(Key[] a) {
        n = a.length;
        pq = (Key[]) new Object[a.length + 1];

        for(int i = 0; i < n;i++) {
            pq[i + 1] = a[i];
        }

        for(int k = n/2; k >= 1; k--) {
            sink(k);
        }
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparator the order in which to compare the keys
     */
    public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator the order in which to compare the keys
     */
    public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Key max() {
        if(isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }

        return pq[1];
    }

    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];

        for(int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }

        pq = temp;
    }

    public void insert(Key x) {
        if(n == pq.length - 1) {
            resize(2*pq.length);
        }

        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }


    private void swim(int k) {
        while(k > 1 && less(k/2,k)) {
            exch(k,k/2);
            k = k/2;
        }
    }

    public Key delMax() {
        if(isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }

        Key max = pq[1];
        exch(1,n--);
        sink(1);
        pq[n + 1] = null;
        if( (n > 0) && (n == (pq.length - 1)/4)) {
            resize(pq.length/2);
        }
        assert isMaxHeap();
        return max;
    }

    private void sink(int k) {
        while(2*k <= n) {
            int j = 2*k;
            if(j < n && less(j, j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

    private boolean less(int i,int j) {
        if(comparator == null) {
            return pq[i].compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i],pq[j]) < 0;
        }
    }

    private void exch(int i , int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    // is pq[1..N] a max heap?
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && less(k, left))  return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }


    /***************************************************************************
     * Iterator.
     ***************************************************************************/

    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in descending order.
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in descending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        // create a new pq
        private MaxPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) copy = new MaxPQ<Key>(size());
            else                    copy = new MaxPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }

    /**
     * Unit tests the {@code MaxPQ} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<String>();
        String[] data = new String[]{"to","be","-","or","to","not","-","-","that","-","-","-"};
        for(String s : data) {
            if(!s.equals("-"))
                pq.insert(s);
            else  {
                System.out.println(pq.delMax());
            }
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }
}
