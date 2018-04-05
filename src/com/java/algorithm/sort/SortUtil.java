package com.java.algorithm.sort;

/**
 * Created by Mihir.Desai on 4/4/2017.
 */
public class SortUtil {
    public static void exchange(Comparable[] a,int i,int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static  boolean less(Comparable v,Comparable u) {
        return v.compareTo(u) < 0;
    }

    public static void show(String description,Comparable[] a) {
        System.out.print(description);
        for(int i = 0; i < a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length;i++) {
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
}
