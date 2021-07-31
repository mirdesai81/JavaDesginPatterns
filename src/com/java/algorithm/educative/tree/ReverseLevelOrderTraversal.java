package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.TreeNode;

import java.util.*;



class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        // TODO: Write your code here
        Queue<TreeNode> current = new ArrayDeque<TreeNode>();
        current.add(root);

        while(!current.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>(current.size());
            Queue<TreeNode> next = new ArrayDeque<TreeNode>();
            while(!current.isEmpty()) {
                TreeNode node = current.poll();
                thisLevel.add(node.val);
                if(node.left != null) next.add(node.left);
                if(node.right != null) next.add(node.right);
            }

            if(!thisLevel.isEmpty()){
                result.add(0,thisLevel);
            }

            current = next;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
