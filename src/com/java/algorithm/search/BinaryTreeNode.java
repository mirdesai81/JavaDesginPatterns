package com.java.algorithm.search;

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
