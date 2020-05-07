package com.java.algorithm.stack;

public class Node {
    public Node above;
    public Node below;
    public int value;

    public Node getAbove() {
        return above;
    }

    public void setAbove(Node above) {
        this.above = above;
    }

    public Node getBelow() {
        return below;
    }

    public void setBelow(Node below) {
        this.below = below;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node(int v) {
        this.value = v;
    }
}
