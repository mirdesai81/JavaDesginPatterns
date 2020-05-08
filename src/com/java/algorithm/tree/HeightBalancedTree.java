package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

public class HeightBalancedTree {

    private static class BalancedStatusWithHeight {
        public int height;
        public boolean balanced;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public boolean isBalanced() {
            return balanced;
        }

        public void setBalanced(boolean balanced) {
            this.balanced = balanced;
        }


        public BalancedStatusWithHeight(boolean balanced,int height) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public static BalancedStatusWithHeight isBalanced(BinaryTreeNode<String> tree) {
        return checkBalanced(tree);
    }


    // Similar to post order traversal where we first check left and right subtree
    private static BalancedStatusWithHeight checkBalanced(BinaryTreeNode<String> tree) {

        if(tree == null) {
            return new BalancedStatusWithHeight(true,-1);
        }

        // if left subtree is not balanced we do not have to visit right subtree
        BalancedStatusWithHeight left = checkBalanced(tree.left);
        if(!left.balanced) {
            return left; // left subtree is not balanced
        }

        BalancedStatusWithHeight right = checkBalanced(tree.right);
        if(!right.balanced) {
            return right; // right subtree is not balanced
        }

        // for a tree to be balanced difference in height between left and right subtree should be <= 1
        boolean isBalanced = Math.abs(left.height - right.height) <= 1;
        // height is max of left and right + 1 for the current node
        int height = Math.max(left.height,right.height) + 1;
        return new BalancedStatusWithHeight(isBalanced,height);

    }


    public boolean isBalanced(BinaryTreeNode<String> tree) {

    }

    public static void main(String[] args) {
        BinaryTreeNode<String> root = new BinaryTreeNode<String>("A");
        //left
        root.left = new BinaryTreeNode<>("B");
        root.left.left = new BinaryTreeNode<>("C");
        root.left.right = new BinaryTreeNode<>("H");
        root.left.left.left = new BinaryTreeNode<>("D");
        root.left.left.right = new BinaryTreeNode<>("G");
        root.left.left.left.left = new BinaryTreeNode<>("E");
        root.left.left.left.right = new BinaryTreeNode<>("F");
        root.left.right.left = new BinaryTreeNode<>("I");
        root.left.right.right = new BinaryTreeNode<>("J");
        //right
        root.right = new BinaryTreeNode<>("K");
        root.right.left = new BinaryTreeNode<>("L");
        root.right.right = new BinaryTreeNode<>("O");
        root.right.left.left = new BinaryTreeNode<>("M");
        root.right.left.right = new BinaryTreeNode<>("N");

        BalancedStatusWithHeight balancedStatusWithHeight = isBalanced(root);
        StdOut.println(balancedStatusWithHeight.balanced);
        StdOut.println("Height of Tree - "+balancedStatusWithHeight.height);
    }
}
