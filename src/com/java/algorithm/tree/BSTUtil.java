package com.java.algorithm.tree;

public class BSTUtil {

    public static BSTNode<Integer> createBST() {
        BSTNode<Integer> root = new BSTNode<>(19);
        root.left = new BSTNode<>(7);
        root.left.left = new BSTNode<>(3);

        root.left.left.left = new BSTNode<>(2);
        root.left.left.right = new BSTNode<>(5);

        root.left.right = new BSTNode<>(11);
        root.left.right.right = new BSTNode<>(17);
        root.left.right.right.left = new BSTNode<>(13);

        root.right = new BSTNode<>(43);
        root.right.right = new BSTNode<>(47);
        root.right.right.right = new BSTNode<>( 53);

        root.right.left = new BSTNode<>(23);
        root.right.left.right = new BSTNode<>(37);
        root.right.left.right.right = new BSTNode<>(41);
        root.right.left.right.left = new BSTNode<>(29);
        root.right.left.right.left.right = new BSTNode<>(31);

        return root;
    }

    public static BSTNode<Integer> createBSTWithDuplicates() {
        BSTNode<Integer> root = new BSTNode<>(108);
        root.left = new BSTNode<>(108);
        root.left.left = new BSTNode<>(-10);

        root.left.left.left = new BSTNode<>(-14);
        root.left.left.right = new BSTNode<>(2);

        root.left.right = new BSTNode<>(108);

        root.right = new BSTNode<>(285);
        root.right.right = new BSTNode<>(285);
        root.right.right.right = new BSTNode<>( 401);

        root.right.left = new BSTNode<>(243);


        return root;
    }

}
