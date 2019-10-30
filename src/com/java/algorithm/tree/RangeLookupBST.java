package com.java.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class RangeLookupBST {

    private static class Interval {
        public int left;
        public int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> rangeLookupInBST(BSTNode<Integer> tree,Interval interval) {
        List<Integer> result = new ArrayList<>();
        rangeLookupHelper(tree,interval,result);
        return result;
    }

    private static void rangeLookupHelper(BSTNode<Integer> tree,Interval interval, List<Integer> result) {
        if(tree == null) {
            return;
        }

        if(interval.left <= tree.data && tree.data <= interval.right) {
            rangeLookupHelper(tree.left,interval,result);
            result.add(tree.data);
            rangeLookupHelper(tree.right,interval,result);
        } else if(interval.left > tree.data) {
            rangeLookupHelper(tree.right,interval,result);
        } else {
            rangeLookupHelper(tree.left,interval,result);
        }
    }

    public static void main(String[] args) {
        List<Integer> result = rangeLookupInBST(BSTUtil.createBST(),new Interval(16,35));
        System.out.println(result);
    }
}
