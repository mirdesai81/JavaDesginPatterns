package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class MirrorBinaryTree {

    public static void mirrorBinaryTree(
            BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        // We will do a post-order traversal of the binary tree.

        if (root.left != null) {
            mirrorBinaryTree(root.left);
        }

        if (root.right != null) {
            mirrorBinaryTree(root.right);
        }

        // Let's swap the left and right nodes at current level.

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] argv) {
        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(20);input1.add(50);input1.add(200);input1.add(75);input1.add(25);input1.add(300);
        BinaryTreeNode root  = BinaryTree.create_BST(input1);
        BinaryTree.display_level_order(root);
        System.out.println();

        mirrorBinaryTree(root);
        System.out.println("Mirrored Tree:");
        BinaryTree.display_level_order(root);
    }
}
