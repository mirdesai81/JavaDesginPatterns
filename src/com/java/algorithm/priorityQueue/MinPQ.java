package com.java.algorithm.priorityQueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;

public class MinPQ<Key extends Comparable<Key>> implements Iterable<Key> {
    private Key[] pq;
    private int n;
    private Comparator<Key> comparator;

    public MinPQ() {
        this(1);
    }

    public MinPQ(int capacity) {
        pq = (Key[]) new Object[capacity + 1];
        n = 0;
    }

    public MinPQ(int capacity,Comparator<Key> comparator) {
        this(capacity);
        this.comparator = comparator;
    }

    public MinPQ(Comparator<Key> comparator) {
        this(1,comparator);
    }

    public MinPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMinHeap();
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key k) {
        if(n == pq.length - 1) {
            resize(2 * pq.length);
        }

        pq[++n] = k;
        swim(n);
        assert isMinHeap();
    }

    private void swim(int k) {
        while(k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    public Key delMin() {
        if(isEmpty()) throw new NoSuchElementException("Priority Key underflow");

        Key min = pq[1];
        exch(1,n--);
        sink(1);
        pq[n + 1] = null;
        if(n > 0 && (n == (pq.length - 1)/4)) resize(pq.length/2);
        assert isMinHeap();
        return min;
    }

    private void sink(int k) {
        while(2*k <= n) {
            int j = 2*k;
            if(j < n && greater(j,j+1)) {
                j++;
            }

            if(!greater(k,j)) break;

            exch(k,j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        if(comparator != null) {
            return comparator.compare(pq[i],pq[j]) > 0;
        } else {
            return pq[i].compareTo(pq[j]) > 0;
        }
    }

    private void exch(int i,int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    private boolean isMinHeap(int k) {
        if(k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if(left <= n && greater(k,left)) return false;
        if(right <= n && greater(k,right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        private MinPQ<Key> copy;

        public HeapIterator() {
            if(comparator == null) {
                copy = new MinPQ<>(size());
            } else {
                copy = new MinPQ<>(size(),comparator);
            }

            for(int i = 1; i <= n ; i++) {
                copy.insert(pq[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Key next() {
            if(!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
