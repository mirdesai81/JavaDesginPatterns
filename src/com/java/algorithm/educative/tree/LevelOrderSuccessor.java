package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        // TODO: Write your code here
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode curr = null;
        q.offer(root);

        while(!q.isEmpty()) {
            curr = q.poll();
            if(curr.left != null) q.offer(curr.left);

            if(curr.right != null) q.offer(curr.right);

            if(curr.val == key) {
                return q.peek();
            }

        }


        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}