package com.java.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxStackWithCachedMax {


    private class ElementWithCachedMax {
        private Integer element;
        private Integer max;

        public ElementWithCachedMax(Integer element, Integer max) {
            this.element = element;
            this.max = max;
        }


    }

    private Deque<ElementWithCachedMax> elementWithCachedMax = new LinkedList<>();

    public boolean empty() {
        return elementWithCachedMax.isEmpty();
    }

    public Integer max() {

        if(empty()) {
            throw new IllegalStateException("max() : empty stack.");
        }

        return elementWithCachedMax.peek().max;
    }

    public void push(Integer x) {
        elementWithCachedMax.addFirst(new ElementWithCachedMax(x, Math.max(x , empty() ? x : max())));
    }

    public Integer pop() {
        if(empty()) {
            throw new IllegalStateException("pop() : empty stack.");
        }

        return elementWithCachedMax.removeFirst().element;
    }
}
