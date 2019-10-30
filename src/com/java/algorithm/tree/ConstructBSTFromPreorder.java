package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructBSTFromPreorder {
    private static Integer rootIdx;


    public static BSTNode<Integer> constructBSTFromPreorder(List<Integer> preorderList) {
        return constructBSTFromPreorderHelper(preorderList,0,preorderList.size());
    }

    public static BSTNode<Integer> constructBSTFromPreorderHelper(List<Integer> preorderList,int start,int end) {
        if(start >= end) {
            return null;
        }

        int transitionPoint = start + 1;
        while(transitionPoint < end &&
                Integer.compare(preorderList.get(transitionPoint),preorderList.get(start)) < 0) {
            ++transitionPoint;
        }


        return new BSTNode<>(preorderList.get(start),
                 constructBSTFromPreorderHelper(preorderList,start + 1,transitionPoint),
                constructBSTFromPreorderHelper(preorderList,transitionPoint,end)
                );
    }


    public static BSTNode<Integer> constructBSTFromPreorderOnValueRange(List<Integer> preorderList) {
        rootIdx = 0;
        return constructBSTFromPreorderHelperOnValueRange(preorderList,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static BSTNode<Integer> constructBSTFromPreorderHelperOnValueRange(List<Integer> preorderList,int lowebound,int upperbound) {

        if(rootIdx == preorderList.size()) {
            return null;
        }
        Integer root = preorderList.get(rootIdx);
        if(root < lowebound || root > upperbound) {
            return null;
        }

        rootIdx++;
        BSTNode<Integer> leftSubstree = constructBSTFromPreorderHelperOnValueRange(preorderList,lowebound,root);
        BSTNode<Integer> rightSubstree = constructBSTFromPreorderHelperOnValueRange(preorderList,root,upperbound);
        return new BSTNode<>(root,
                leftSubstree,
                rightSubstree
        );
    }

    public static void main(String[] args) {
        List<Integer> preorder = new ArrayList<>(Arrays.asList(43,23,37,29,31,41,47,53));
        StdOut.println(constructBSTFromPreorder(preorder));

        StdOut.println(constructBSTFromPreorderOnValueRange(preorder));
    }
}
