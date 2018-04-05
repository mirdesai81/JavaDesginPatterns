package com.java.algorithm.sort;

/**
 * Created by Mihir.Desai on 4/24/2017.
 */
public class HeapSort implements Sort {
    @Override
    public void sort(Comparable[] pq) {
        int n = pq.length - 1;
        // Ordered the tree
        for(int k = n/2; k >= 0; k--) {
            sink(pq,k,n);
        }
        HeapSort.show(pq);
        // Sort the tree based on natural order
        while(n > 0) {
            exchange(pq,0,n--);
            sink(pq,0,n);
        }
    }

    // Helper functions
    private void sink(Comparable[] pq,int k,int n) {
        while(2*k <= n) {
            int j = 2*k;
            if(j < n && less(pq,j,j+1)) j++;
            if(!less(pq,k,j)) break;
            exchange(pq,k,j);
            k = j;
        }
    }

    /**
     * Off by one to support 1 based indexing
     * @param pq
     * @param i
     * @param j
     * @return
     */
    private boolean less(Comparable[] pq,int i,int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(Comparable[] pq,int i,int j) {
        Comparable v = pq[i];
        pq[i] = pq[j];
        pq[j] = v;
    }

    private static void show(Comparable[] a) {
        for(int i =0; i < a.length; i++) {
            if(i == a.length-1) {
                System.out.print(a[i]);
            } else
                System.out.print(a[i] + " , ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] a = new String[] {"Z","S","O","R","T","E","X","A","M","P","L","E","N","D"};
        HeapSort heap = new HeapSort();
        heap.sort(a);
        show(a);
    }

}
