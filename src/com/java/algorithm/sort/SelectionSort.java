package com.java.algorithm.sort;

/**
 * Created by Mihir.Desai on 4/4/2017.
 */
public class SelectionSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 0; i < N; i++) {
            int min = i;
            for(int j = i+1; j < N; j++) {
                if(SortUtil.less(a[j],a[min])) {
                    min = j;
                }
            }
            SortUtil.exchange(a,i,min);
            /*SortUtil.show("During Sort -> " ,a);*/
        }
    }
}
