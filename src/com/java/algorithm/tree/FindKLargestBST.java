package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.List;

public class FindKLargestBST {

    public static List<Integer> findKLargest(BSTNode<Integer> tree,int k) {
        List<Integer> kLargest = new ArrayList<>();
        findKLargestHelper(tree,k,kLargest);
        return kLargest;
    }

    private static void findKLargestHelper(BSTNode<Integer> tree,int k,List<Integer> kLargest) {

        if(tree != null && kLargest.size() < k) {
            findKLargestHelper(tree.right,k,kLargest);
            if(kLargest.size() < k) {
                kLargest.add(tree.data);
                findKLargestHelper(tree.left,k,kLargest);
            }
        }

    }

    public static void main(String[] args) {
        StdOut.println(findKLargest(BSTUtil.createBST(),3));
    }
}
