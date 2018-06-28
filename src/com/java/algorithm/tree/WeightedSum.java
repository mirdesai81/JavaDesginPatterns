package com.java.algorithm.tree;

public class WeightedSum {

    public static boolean weightedSumEqauls(BinaryTreeNode<Integer> root,int sum) {
        return weightedSumEqualsHelper(root,0,sum);
    }

    private static boolean weightedSumEqualsHelper(BinaryTreeNode<Integer> root,int partialSum,int sum) {
        if(root == null) {
            return false;
        }

        partialSum = partialSum + root.data;

        if(root.left == null && root.right == null) {
            return partialSum == sum;
        }

        return weightedSumEqualsHelper(root.left,partialSum,sum) || weightedSumEqualsHelper(root.right,partialSum,sum);
    }

    public static void main(String[] arga) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);

        // left subtree
        root.left = new BinaryTreeNode<>(6);
        root.left.left = new BinaryTreeNode<>(271);
        root.left.left.left = new BinaryTreeNode<>(28);
        root.left.left.right = new BinaryTreeNode<>(0);

        root.left.right = new BinaryTreeNode<>(561);
        root.left.right.right = new BinaryTreeNode<>(3);
        root.left.right.right.left = new BinaryTreeNode<>(17);

        //right subtree
        root.right = new BinaryTreeNode<>(6);
        root.right.left = new BinaryTreeNode<>(2);
        root.right.left.right = new BinaryTreeNode<>(1);
        root.right.left.right.left = new BinaryTreeNode<>(401);
        root.right.left.right.right = new BinaryTreeNode<>(257);
        root.right.left.right.left.right = new BinaryTreeNode<>(641);

        root.right.right = new BinaryTreeNode<>(271);
        root.right.right.right = new BinaryTreeNode<>(28);

        System.out.println(weightedSumEqauls(root,591));
    }
}
