package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;
import com.java.algorithm.educative.tree.base.TreeNode;

class N_aryBinaryConversion {
    public static BinaryTreeNode convertN_aryToBinary(TreeNode root) {
        return convertN_aryToBinary(root, true);
    }

    public static BinaryTreeNode convertN_aryToBinary(TreeNode node, boolean isLeft) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode btnode = new BinaryTreeNode(node.val);
        BinaryTreeNode lastnode = btnode;
        for(int i=0; i < node.Children.size() ; i++) {
            if(isLeft) {
                lastnode.left = convertN_aryToBinary(
                        node.Children.get(i), !isLeft);
                lastnode = lastnode.left;
            }
            else {
                lastnode.right = convertN_aryToBinary(
                        node.Children.get(i), !isLeft);
                lastnode = lastnode.right;
            }
        }
        return btnode;
    }

    public static TreeNode convertBinaryToN_aryTree(BinaryTreeNode root) {
        return convertBinaryToN_aryTreeRec(root, true);
    }

    public static TreeNode convertBinaryToN_aryTreeRec(BinaryTreeNode node, boolean isLeft) {
        if(node == null) {
            return null;
        }

        TreeNode nnode = new TreeNode(node.data);
        BinaryTreeNode temp = node;

        if(isLeft) {
            while(temp.left != null) {
                TreeNode child = convertBinaryToN_aryTreeRec(
                        temp.left, !isLeft);
                nnode.Children.add(child);
                temp = temp.left;
            }
        }
        else {
            while(temp.right != null) {
                TreeNode child = convertBinaryToN_aryTreeRec(
                        temp.right, !isLeft);
                nnode.Children.add(child);
                temp = temp.right;
            }
        }
        return nnode;
    }

    public static void main(String[] argv) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.Children.add(node2);
        node1.Children.add(node3);
        node1.Children.add(node4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node3.Children.add(node5);
        node3.Children.add(node6);

        System.out.println("Original n-ary tree");
        TreeNode.display_level_order(node1);

        BinaryTreeNode bnode1 = convertN_aryToBinary(node1);
        System.out.println("\nConverted binary tree");
        BinaryTree.display_level_order(bnode1);
        // If the tree is converted into BT then the following statement must return "5"
        // System.out.println("\nRoot.Left.Left.Right = " + bnode1.left.left.right.data);

        // System.out.println("Converting BT to N_ary Tree\n");
        TreeNode tnode1 = convertBinaryToN_aryTree(bnode1);
        System.out.println("Converted n-ary tree");
        TreeNode.display_level_order(tnode1);
    }
}