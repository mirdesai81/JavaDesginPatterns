package com.java.algorithm.search;

public class SymmetricTree {

    public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
        return (tree == null || checkSymmetric(tree.left,tree.right));
    }

    private static boolean checkSymmetric(BinaryTreeNode<Integer> node1,BinaryTreeNode<Integer> node2) {

        if(node1 == null && node2 == null) {
            return true;
        } else if(node1 != null && node2 != null) {
            return node1.data == node2.data && checkSymmetric(node1.left,node2.right)
                    && checkSymmetric(node1.right,node2.left);
        }

        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);
        root.left = new BinaryTreeNode<>(6);
        root.left.right = new BinaryTreeNode<>(2);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right.right = new BinaryTreeNode<>(3);
        root.left.right.left = new BinaryTreeNode<>(6);

        root.right = new BinaryTreeNode<>(6);
        root.right.left = new BinaryTreeNode<>(2);
        root.right.right = new BinaryTreeNode<>(4);
        root.right.left.left = new BinaryTreeNode<>(3);
        root.right.left.right = new BinaryTreeNode<>(6);

        System.out.println(isSymmetric(root));
    }
}
