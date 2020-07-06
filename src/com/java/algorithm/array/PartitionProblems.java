package com.java.algorithm.array;

import com.java.stdlib.StdOut;

public class PartitionProblems {

    public static void rearrange(int[] A) {
        int p = partitionAtZero(A);

        for(int i = 0; p < A.length && i < p; i = i + 2) {
            swap(A,i+1,p++);
        }
    }

    public static int partitionAtZero(int[] A) {
        int j = 0;

        for(int i = 0 ; i < A.length; i++) {
            if(A[i] < 0) {
                swap(A,i,j);
                j++;
            }
        }

        return j;
    }

    public static void swap(int[] A,int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A= {10,20,30,-10,-20,40,-30,-40};
        ArrayUtils.print("Before",A);
        rearrange(A);
        ArrayUtils.print("After",A);
    }
}
