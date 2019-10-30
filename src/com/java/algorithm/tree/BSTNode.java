package com.java.algorithm.tree;

import com.java.stdlib.Helper;

public class BSTNode<T> {
    public T data;
    public BSTNode<T> left, right;

    private static int AMOUNT_INDENT = 3;


    public BSTNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
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


        newLine(builder);
        if (left != null) {
            indent(builder, indent);
            builder.append("|_" + Helper.repeat(AMOUNT_INDENT, "_") + left.toString(indent + 1));
        }
        if (right != null) {
            indent(builder, indent);
            builder.append("|_" + Helper.repeat(AMOUNT_INDENT, "_") + right.toString(indent + 1));
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
