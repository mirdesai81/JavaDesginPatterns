package com.java.algorithm.sort;

import java.util.NoSuchElementException;

/**
 * Created by Mihir.Desai on 4/24/2017.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public MaxPQ() {
        this(1);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() { return N;}

    /**
     * Returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > N;
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }


    public void insert(Key v) {
        if(N >= pq.length - 1) resize(2*pq.length);
        pq[++N] = v;
        swim(N);
        assert isMaxHeap();
    }

    public Key delMax() {
        if(isEmpty()) throw new NoSuchElementException("Priority Queue underflow");
        Key max = pq[1];
        exchange(1,N--);
        pq[N+1] = null;
        sink(1);
        if( (N > 0) && (N == (pq.length -1)/4)) resize(pq.length/2);
        return max;
    }

    private boolean less(int i,int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // is pq[1..N] a max heap?
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
        if (k > N) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= N && less(k, left))  return false;
        if (right <= N && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }



    /**
     * bottom up reheapify
     * swim means move from bottom to up
     * @param k
     */
    private void swim(int k) {
        while(k > 1 && less(k/2,k)) {
            exchange(k/2,k);
            k = k/2;
        }
    }

    /**
     * top to bottom
     * sink means move key from top to bottom
     * @param k
     */
    private void sink(int k) {
        while(2*k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exchange(k,j);
            k = j;
        }
    }

    /**
            * Unit tests the {@code MaxPQ} data type.
            *
            * @param args the command-line arguments
    */
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<String>();
        String[] data = new String[] {"S","O","-","R","T","-","E","A","-","M","P","L","E"};

        for(int i = 0; i < data.length; i++) {
            String item = data[i];
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) System.out.print(pq.delMax() + " ");
        }
        System.out.println("(" + pq.size() + " left on pq)");
    }
}
