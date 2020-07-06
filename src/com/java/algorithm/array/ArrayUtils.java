package com.java.algorithm.array;

public class ArrayUtils {

    public static void print(String msg,int a[]) {
        if(msg != null) {
            System.out.println(msg + " : ");
        }
        for(int i = 0; i < a.length;++i) {
            if(i == a.length - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + " --> ");
            }
        }

        System.out.println();
    }



    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
