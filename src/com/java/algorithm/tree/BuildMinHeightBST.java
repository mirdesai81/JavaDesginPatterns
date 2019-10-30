package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildMinHeightBST {

    public static BSTNode<Integer> buildMinHeightBST(List<Integer> A) {
        return buildMinHeightBSTHelper(A,0, A.size());
    }

    public static BSTNode<Integer> buildMinHeightBSTHelper(List<Integer> A, int start , int end) {
        if(start >= end) {
            return null;
        }

        int mid = start + ( end - start) / 2;

        return new BSTNode<>(A.get(mid) ,
                buildMinHeightBSTHelper(A, start, mid),
                buildMinHeightBSTHelper(A,mid + 1, end));
    }

    public static void main(String[] args) {
        List<Integer>  A = new ArrayList<>(Arrays.asList(2,3,5,7,11,13,17,19,23));
        StdOut.println(buildMinHeightBST(A));
    }
}
