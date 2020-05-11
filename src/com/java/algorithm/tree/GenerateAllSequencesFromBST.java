package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.LinkedList;

public class GenerateAllSequencesFromBST {

    public  ArrayList<LinkedList<Integer>> allSequences(BSTNode<Integer> node) {

        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

        if(node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.data);

        ArrayList<LinkedList<Integer>> leftResult = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightResult = allSequences(node.right);

        // weave left and right
        for(LinkedList<Integer> left : leftResult) {
            for(LinkedList<Integer> right : rightResult) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weave(left,right,weaved,prefix);
                result.addAll(weaved);
             }
        }

        return result;
    }

    public  void weave(LinkedList<Integer> first,LinkedList<Integer> second,
                      ArrayList<LinkedList<Integer>> results,
                      LinkedList<Integer> prefix) {

        if(first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weave(first,second,results,prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weave(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public static void main(String[] args) {
        BSTNode<Integer> tree = BSTUtil.createBST();
        GenerateAllSequencesFromBST generate = new GenerateAllSequencesFromBST();
        ArrayList<LinkedList<Integer>> result = generate.allSequences(tree);
        StdOut.println(result);
    }
}