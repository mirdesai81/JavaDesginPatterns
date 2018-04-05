package com.java.algorithm.sort;

/**
 * Created by Mihir.Desai on 4/4/2017.
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        // unsorted list
       for(int i = 1 ; i < N; i++) {
            for(int j = i ; j > 0 && SortUtil.less(a[j],a[j-1]); j--) {
                SortUtil.exchange(a,j,j-1);
            }
        }
    }

}
