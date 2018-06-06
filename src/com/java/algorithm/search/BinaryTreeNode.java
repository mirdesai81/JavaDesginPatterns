package com.java.algorithm.search;

public class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left, right = null;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
