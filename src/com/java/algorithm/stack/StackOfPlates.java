package com.java.algorithm.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackOfPlates {
    ArrayList<ArrayStack<Integer>> stacks = new ArrayList<>();

    public void push(int v) {
        ArrayStack<Integer> last = getLastStack();
        if(last != null && !last.isFull()) {
            last.push(v);
        } else {
            ArrayStack<Integer> stack = new ArrayStack<>();
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() {
        ArrayStack<Integer> last = getLastStack();
        if(last == null) throw new EmptyStackException();

        Integer value = last.pop();
        if(last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }

    public boolean isEmpty() {
        ArrayStack<Integer> last = getLastStack();
        return last == null || last.isEmpty();
    }

    private ArrayStack<Integer> getLastStack() {
        return stacks.get(stacks.size() - 1);
    }


}
