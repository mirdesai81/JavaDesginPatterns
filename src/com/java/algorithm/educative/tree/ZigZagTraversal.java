package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigZagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean leftToRight = true;
        // TODO: Write your code here
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode curr = null;
        while (!q.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                curr = q.poll();

                if (leftToRight) {
                    thisLevel.add(curr.val);
                } else {
                    thisLevel.add(0, curr.val);
                }

                if (curr.left != null) q.offer(curr.left);

                if (curr.right != null) q.offer(curr.right);
            }

            if (!thisLevel.isEmpty()) {
                result.add(thisLevel);
            }

            leftToRight = !leftToRight;

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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}