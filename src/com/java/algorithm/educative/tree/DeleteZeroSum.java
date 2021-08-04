package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;

public class DeleteZeroSum {

    public static int deleteZeroSumSubtreeRec(
            BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum_left =
                deleteZeroSumSubtreeRec(root.left);
        int sum_right =
                deleteZeroSumSubtreeRec(root.right);

        if (sum_left == 0) {
            root.left = null;
        }

        if (sum_right == 0) {
            root.right = null;
        }

        return root.data + sum_left + sum_right;
    }

    public static void deleteZeroSumSubtree(
            BinaryTree tree) {

        if (tree == null || tree.root == null) {
            return;
        }

        if (0 == deleteZeroSumSubtreeRec(tree.root)) {
            tree.root = null;
        }
    }

    public static BinaryTreeNode createTestTree() {
        BinaryTreeNode head = new BinaryTreeNode(7);
        BinaryTreeNode currentHead = head;

        BinaryTreeNode left = new BinaryTreeNode(5);
        BinaryTreeNode right = new BinaryTreeNode(6);//
        currentHead.left = left;
        currentHead.right = right;

        currentHead = head.left;
        left = new BinaryTreeNode(-3);
        right = new BinaryTreeNode(-2);
        currentHead.left = left;
        currentHead.right = right;

        return head;
    }

    public static void main(String[] argv) {
        BinaryTreeNode root = createTestTree();
        BinaryTree tree = new BinaryTree(root);
        System.out.println("Level Order Traversal");
        BinaryTree.display_level_order(tree.root);
        System.out.println("Level Order Traversal");
        deleteZeroSumSubtree(tree);
        BinaryTree.display_level_order(tree.root);
    }
}
