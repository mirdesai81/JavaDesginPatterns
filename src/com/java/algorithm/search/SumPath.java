package com.java.algorithm.search;

public class SumPath {

    public static int sumRootToLeaf(BinaryTreeNode<Integer> root) {
        return sumRootToLeafHelper(root,0);
    }

    private static int sumRootToLeafHelper(BinaryTreeNode<Integer> root,int partialSum) {
        if(root == null) {
            return 0;
        }

        partialSum = partialSum * 2 + root.data;
        if(root.left == null && root.right == null) {
            return partialSum;
        }

        //non - leaf nodes
        return sumRootToLeafHelper(root.left,partialSum) + sumRootToLeafHelper(root.right,partialSum);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);

        // left subtree
        root.left = new BinaryTreeNode<>(0);
        root.left.left = new BinaryTreeNode<>(0);
        root.left.left.left = new BinaryTreeNode<>(0);
        root.left.left.right = new BinaryTreeNode<>(1);

        root.left.right = new BinaryTreeNode<>(1);
        root.left.right.right = new BinaryTreeNode<>(1);
        root.left.right.right.left = new BinaryTreeNode<>(0);

        //right subtree
        root.right = new BinaryTreeNode<>(1);
        root.right.left = new BinaryTreeNode<>(0);
        root.right.left.right = new BinaryTreeNode<>(0);
        root.right.left.right.left = new BinaryTreeNode<>(1);
        root.right.left.right.right = new BinaryTreeNode<>(0);
        root.right.left.right.left.right = new BinaryTreeNode<>(1);

        root.right.right = new BinaryTreeNode<>(0);
        root.right.right.right = new BinaryTreeNode<>(0);

        System.out.println(sumRootToLeaf(root));
    }
}
