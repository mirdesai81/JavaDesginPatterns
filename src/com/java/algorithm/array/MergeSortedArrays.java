package com.java.algorithm.array;

public class MergeSortedArrays {

    public static void merge(int[] a, int aSIze,int[] b,int bSize) {
        int aLen = aSIze - 1;
        int bLen = bSize - 1;
        int totalLen = aSIze + bSize - 1;

        while(aLen >= 0 && bLen >= 0) {
            if(a[aLen] >= b[bLen]) {
                a[totalLen--] = a[aLen--];
            } else {
                a[totalLen--] = b[bLen--];
            }
        }

        while(bLen >= 0) {
            a[totalLen--] = b[bLen--];
        }

        ArrayUtils.print("Merge two sorted arrays with additional space available ", a);
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 1 , 3, 9, 16, 0 , 0, 0 };
        int[] b = new int[] { 2, 10, 15};
        merge(a,4,b,3);
    }
}
