package com.java.algorithm.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> min = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(Integer v) {
        if(v <= min()) {
            min.push(v);
        }

        stack.push(v);
    }



    public Integer pop() {
        Integer value = stack.pop();
        if(value.compareTo(min()) == 0) {
            min.pop();
        }

        return value;
    }

    public Integer min() {
        if(min.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return min.peek();
        }
    }
}
