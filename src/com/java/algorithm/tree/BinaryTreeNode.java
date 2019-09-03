package com.java.algorithm.tree;

import com.java.stdlib.Helper;

public class BinaryTreeNode<T> {
    T data;
    int height;
    int size;
    BinaryTreeNode<T> left, right, parent = null,next;

    private static int AMOUNT_INDENT = 3;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 1;
        this.size = 1;
    }

    public BinaryTreeNode(T data,BinaryTreeNode<T> left,BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
       // this.size = 1 + size(this.left) + size(this.right);
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void indent(StringBuilder builder, int indent) {
        builder.append(Helper.repeat(indent * (AMOUNT_INDENT + 1), " "));
    }

    public void newLine(StringBuilder builder) {
        builder.append(System.lineSeparator());
    }

    public String toString(int indent) {
        StringBuilder builder = new StringBuilder();
        builder.append(data);

        if(next != null) {
            builder.append(","+next.data);
        } else {
            builder.append(",NULL");
        }

        newLine(builder);
        if (left != null) {
            indent(builder, indent);
            builder.append("└" + Helper.repeat(AMOUNT_INDENT, "─") + left.toString(indent + 1));
        }
        if (right != null) {
            indent(builder, indent);
            builder.append("└" + Helper.repeat(AMOUNT_INDENT, "─") + right.toString(indent + 1));
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
