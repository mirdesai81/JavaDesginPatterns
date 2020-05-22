package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

public class ArrayBinaryTreeSumSubtree {

    public static long subTreeSum(long[] arr,int i,long partialSum) {
        if(i >= arr.length || arr[i] == -1) {
            return 0;
        }

        if(i < arr.length) {


            // left subtree
            long left = subTreeSum(arr,2*i + 1,partialSum);

             long right = subTreeSum(arr,2*i + 2,partialSum);

             partialSum = partialSum + arr[i] + left + right;
        }

        return partialSum;

    }

    public static String findMaxSubtreeWithSum(long[] arr) {

        if(arr == null || arr.length <= 1) {
            return "";
        }

        if(arr.length == 2) {
            return "Left";
        }

        long left = arr[0] + subTreeSum(arr,1,0);
        long right = arr[0] + subTreeSum(arr,2,0);

        return left == right ? "" : left > right ? "Left" : "Right";
    }

    public static void main(String[] args) {
        long[] arr = {3,6,2,9,-1,10};
        StdOut.println(findMaxSubtreeWithSum(arr));
    }

}
