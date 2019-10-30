package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

public class FindFirstGreaterThanKInBST {


    public static BSTNode<Integer> findFirstGreaterThanK(BSTNode<Integer> tree,Integer k) {
        BSTNode<Integer> curr = tree;
        BSTNode<Integer> firstSoFar = null;
        while(curr != null) {
            if(curr.data > k) {
                firstSoFar = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return firstSoFar;
    }

    public static BSTNode<Integer> findFirstEqualToK(BSTNode<Integer> tree,Integer k) {
        BSTNode<Integer> curr = tree;
        BSTNode<Integer> firstSoFar = null;
        while(curr != null) {
            int cmp = curr.data.compareTo(k);
            if(cmp == 0) {
                firstSoFar = curr;
                curr = curr.left;
            } else if(cmp > 0){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return firstSoFar;
    }


    public static void main(String[] args) {
        BSTNode<Integer> node = findFirstGreaterThanK(BSTUtil.createBST(),17);
        StdOut.println(node.data);

        node = findFirstEqualToK(BSTUtil.createBSTWithDuplicates(), 108);
        StdOut.println(node);
        StdOut.println(node.right.data);
        StdOut.println(node.left.data);

        node = findFirstEqualToK(BSTUtil.createBSTWithDuplicates(), 285);
        StdOut.println(node);
        StdOut.println(node.right.data);
        StdOut.println(node.left.data);


    }
}
