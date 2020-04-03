package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    private static List<Integer> findKLargestIterative(BSTNode<Integer> tree,int k) {
        List<Integer> kLargest = new ArrayList<>();
        Stack<BSTNode<Integer>> stack = new Stack<>();
        BSTNode<Integer> curr = tree;

        while(curr != null || kLargest.size() < k) {

           /* if(kLargest.size() == k) {
                break;
            }*/

            if(curr != null) {
                stack.push(curr);
                curr = curr.right;
            } else  {
                curr = stack.pop();
                kLargest.add(curr.data);
                curr = curr.left;
            }
        }

        return kLargest;
    }

    public static void main(String[] args) {
        StdOut.println(findKLargest(BSTUtil.createBST(),10));
        StdOut.println(findKLargestIterative(BSTUtil.createBST(),10));
    }
}
