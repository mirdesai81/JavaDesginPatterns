package com.java.algorithm.tree;

import java.util.HashMap;

public class CountPathsWithTargetSum {

    public static int countPathsWithTargetSum(BinaryTreeNode<Integer> tree,int targetSum) {
        return countPathsWithTargetSum(tree,targetSum,0,new HashMap<>());
    }

    private static int countPathsWithTargetSum(BinaryTreeNode<Integer> node, int targetSum, int runningSum, HashMap<Integer,Integer> pathCount) {
        if(node == null) return 0;

        runningSum += node.data;
        int sum = targetSum - runningSum;
        int totalPaths = pathCount.getOrDefault(sum,0);

        if(runningSum == targetSum) {
            totalPaths++;
        }

        incrementHashTable(pathCount,runningSum,1);
        totalPaths += countPathsWithTargetSum(node.left,targetSum,runningSum,pathCount);
        totalPaths += countPathsWithTargetSum(node.right,targetSum,runningSum,pathCount);
        incrementHashTable(pathCount,runningSum, -1);

        return totalPaths;
    }

    public static void incrementHashTable(HashMap<Integer,Integer> map,int key,int delta) {
        int newCount = map.getOrDefault(key,0) + delta;
        if(newCount == 0) {
            map.remove(key);
        } else {
            map.put(key,newCount);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);

        // left subtree
        root.left = new BinaryTreeNode<>(6);
        root.left.left = new BinaryTreeNode<>(271);
        root.left.left.left = new BinaryTreeNode<>(28);
        root.left.left.right = new BinaryTreeNode<>(0);

        root.left.right = new BinaryTreeNode<>(561);
        root.left.right.right = new BinaryTreeNode<>(3);
        root.left.right.right.left = new BinaryTreeNode<>(17);

        //right subtree
        root.right = new BinaryTreeNode<>(6);
        root.right.left = new BinaryTreeNode<>(2);
        root.right.left.right = new BinaryTreeNode<>(1);
        root.right.left.right.left = new BinaryTreeNode<>(401);
        root.right.left.right.right = new BinaryTreeNode<>(257);
        root.right.left.right.left.right = new BinaryTreeNode<>(641);

        root.right.right = new BinaryTreeNode<>(271);
        root.right.right.right = new BinaryTreeNode<>(28);

        System.out.println(countPathsWithTargetSum(root,591));
    }

}
