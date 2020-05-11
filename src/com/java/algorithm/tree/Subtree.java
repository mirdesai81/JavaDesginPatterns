package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

public class Subtree {

    public static boolean containsTree(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {
        if(t2 == null) return true;

        return subTree(t1,t2);
    }

    public static boolean subTree(BinaryTreeNode<Integer> r1, BinaryTreeNode<Integer> r2) {

        if(r1 == null) {
            return false;
        } else if(r1.data.equals(r2.data) && matchTree(r1,r2)) {
            return true;
        }

        return subTree(r1.left,r2) || subTree(r1.right,r2);
    }

    public static boolean matchTree(BinaryTreeNode<Integer> r1, BinaryTreeNode<Integer> r2) {
        if(r1 == null && r2 == null) {
            return true;
        } else if(r1 == null || r2 == null) {
            return false;
        } else if(!r1.data.equals(r2.data)) {
            return false;
        }

        return matchTree(r1.left,r2.left) && matchTree(r1.right,r2.right);
    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> parent = new BinaryTreeNode<>(314);
        parent.setLeft(new BinaryTreeNode<>(6));
        parent.setRight(new BinaryTreeNode<>(6));

        parent.getLeft().setLeft(new BinaryTreeNode<>(271));
        parent.getLeft().setRight(new BinaryTreeNode<>(561));
        parent.getRight().setLeft(new BinaryTreeNode<>(2));
        parent.getRight().setRight(new BinaryTreeNode<>(271));

        parent.getLeft().getLeft().setLeft(new BinaryTreeNode<>(28));
        parent.getLeft().getLeft().setRight(new BinaryTreeNode<>(271));
        parent.getLeft().getRight().setLeft(new BinaryTreeNode<>(0));
        parent.getLeft().getRight().setRight(new BinaryTreeNode<>(3));

        parent.getRight().getLeft().setLeft(new BinaryTreeNode<>(1));
        parent.getRight().getLeft().setRight(new BinaryTreeNode<>(28));
        parent.getRight().getRight().setLeft(new BinaryTreeNode<>(5));
        parent.getRight().getRight().setRight(new BinaryTreeNode<>(10));

        parent.getRight().getLeft().getLeft().setLeft(new BinaryTreeNode<>(17));
        parent.getRight().getLeft().getLeft().setRight(new BinaryTreeNode<>(401));
        parent.getRight().getLeft().getRight().setLeft(new BinaryTreeNode<>(257));

        BinaryTreeNode<Integer> subtree = new BinaryTreeNode<>(6);
        subtree.setLeft(new BinaryTreeNode<>(2));
        subtree.setRight(new BinaryTreeNode<>(271));

        subtree.getLeft().setLeft(new BinaryTreeNode<>(1));
        subtree.getLeft().setRight(new BinaryTreeNode<>(28));
        subtree.getRight().setLeft(new BinaryTreeNode<>(5));
        subtree.getRight().setRight(new BinaryTreeNode<>(10));

        subtree.getLeft().getLeft().setLeft(new BinaryTreeNode<>(17));
        subtree.getLeft().getLeft().setRight(new BinaryTreeNode<>(401));
        subtree.getLeft().getRight().setLeft(new BinaryTreeNode<>(257));


        boolean contains = containsTree(parent,subtree);
        StdOut.println(contains);

    }
}
