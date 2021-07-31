package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectLevelOrderSiblings {

    public static void connect(TreeNode root) {
        // TODO: Write your code here
        if(root == null) return;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode prev = null;
            for(int i = 0 ; i < size; i++) {
                TreeNode curr = q.poll();
                if(prev != null) {
                    prev.next = curr;
                }

                prev = curr;
                if(curr.left != null) q.add(curr.left);

                if(curr.right != null) q.add(curr.right);
            }

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
