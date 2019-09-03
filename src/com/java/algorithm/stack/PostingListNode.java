package com.java.algorithm.stack;

public class PostingListNode {
    private PostingListNode next;
    private PostingListNode jump;
    private int order;

    public PostingListNode(int order,PostingListNode jump, PostingListNode next) {
        this.next = next;
        this.jump = jump;
        this.order = order;
    }

    public PostingListNode getNext() {
        return next;
    }

    public void setNext(PostingListNode next) {
        this.next = next;
    }

    public PostingListNode getJump() {
        return jump;
    }

    public void setJump(PostingListNode jump) {
        this.jump = jump;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
