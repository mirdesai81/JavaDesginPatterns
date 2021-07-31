package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.TreeNode;

import java.util.*;



class LevelOrderAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> current = new ArrayDeque<>();
        current.add(root);
        TreeNode node = null;

        while(!current.isEmpty()) {
            int sum = 0;
            int size = current.size();
            Queue<TreeNode> next = new ArrayDeque<>();

            for(int i = 0; i < size; i++) {
                node = current.poll();
                sum += node.val;
                if(node.left != null) current.add(node.left);
                if(node.right != null) current.add(node.right);
            }
           /* while(!current.isEmpty()) {
                node = current.poll();
                sum += node.val;
                if(node.left != null) next.add(node.left);
                if(node.right != null) next.add(node.right);
            }*/

            if(size > 0) {
                result.add((double) sum/size);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelOrderAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
