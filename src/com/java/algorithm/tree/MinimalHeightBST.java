package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

public class MinimalHeightBST {

    public static BSTNode<Integer> createMinimalBST(int[] arr) {
        return createMinimalBSTHelper(arr,0,arr.length - 1);
    }

    public static BSTNode<Integer> createMinimalBSTHelper(int[] arr,int start, int end) {
        if(end < start) return null;

        int mid = start + (end - start)/2;
        BSTNode<Integer> n = new BSTNode<>(arr[mid]);
        n.left = createMinimalBSTHelper(arr,start,mid - 1);
        n.right = createMinimalBSTHelper(arr, mid + 1, end);
        return n;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90,100,110,120};
        BSTNode<Integer> tree = createMinimalBST(arr);
        StdOut.println(tree.toString());
    }
}
