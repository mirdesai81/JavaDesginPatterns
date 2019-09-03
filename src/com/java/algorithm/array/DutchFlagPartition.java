package com.java.algorithm.array;

public class DutchFlagPartition {

    private static void partition(int[] A, int p) {
        int pivot = A[p],smaller = 0, equal = 0, larger = A.length;

        while(equal < larger) {
            if(A[equal] < pivot) {
                ArrayUtils.swap(A, smaller++, equal++);
            } else if(A[equal] == pivot) {
                equal++;
            } else {
                ArrayUtils.swap(A,equal,--larger);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] { 1, 2, 2, 0, 1, 0, 1, 0 };
        partition(A, 0);
        ArrayUtils.print("Dutch Flag Problem - ",A);
    }
}
