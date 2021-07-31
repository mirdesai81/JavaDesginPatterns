package com.java.algorithm.educative.array;

import java.util.Arrays;

public class FindMaxSumSubarray {

    public static int findMaxSumSubArray(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }

        int currMax = arr[0];
        int globalMax = arr[0];
        int lengtharray = arr.length;
        int start = 0, end = 0;
        for (int i = 1; i < lengtharray; i++) {
            if (currMax < 0) {
                currMax = arr[i];
                start = i;
            } else {
                currMax += arr[i];
            }

            if (globalMax < currMax) {
                globalMax = currMax;
                end = i;
            }
        }
        System.out.println("start = "+start+" ,end = "+end);
        return globalMax;
    }
    public static void main( String args[] ) {
        int[] arr1 = {-1, 7, -2, -5, 10, 2};
        System.out.println("Array: "+ Arrays.toString(arr1));
        System.out.println("Sum: " + findMaxSumSubArray(arr1));
    }

}
