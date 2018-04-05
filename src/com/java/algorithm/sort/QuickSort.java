package com.java.algorithm.sort;

/**
 * Created by Mihir.Desai on 4/7/2017.
 */
public class QuickSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        sort(a,0,a.length - 1);
    }

    private void sort(Comparable[] a,int low,int high) {
        if(high <= low) return;
        int j = partition(a,low,high);
        sort(a,low,j-1);
        sort(a,j+1,high);
    }

    private int partition(Comparable[] a,int low,int high){
        int i = low, j = high + 1;
        Comparable v = a[low];
        while(true) {
            while(SortUtil.less(a[++i],v)) if(i == high) break;
            while(SortUtil.less(v,a[--j])) if(j == low) break;

            if(i >= j) break;

            SortUtil.exchange(a,i,j);
        }
        SortUtil.exchange(a,low,j);
        return j;
    }
}
