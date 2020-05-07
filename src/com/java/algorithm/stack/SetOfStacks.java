package com.java.algorithm.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;


public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList();
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(Integer v) {
        Stack stack = getLastStack();

        if(stack != null && !stack.isFull()) {
            stack.push(v);
        } else {
            Stack s = new Stack();
            s.push(v);
            stacks.add(s);
        }
    }

    public Integer pop() {
        Stack stack = getLastStack();
        if(stack == null || stack.isEmpty()) {
            throw new EmptyStackException();
        }

        int v = stack.pop();

        if(stack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return v;
    }

    public boolean isEmpty() {
        Stack stack = getLastStack();
        return stack == null || stack.isEmpty();
    }

    public Integer peek() {
        Stack stack = getLastStack();
        if(stack == null || stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.peek();
    }

    private Stack getLastStack() {
        if(stacks.size() == 0) return null;

        return stacks.get(stacks.size() - 1);
    }


    public int popAt(int index) {
        return leftShift(index,true);
    }

    private int leftShift(int index,boolean removeTop) {
        Stack stack = stacks.get(index);
        int removed_item;
        if(removeTop) removed_item = stack.pop();
        else removed_item = stack.removeBottom();

        if(stack.isEmpty()) {
            stacks.remove(index);
        } else if(stacks.size() > index + 1) {
            int v = leftShift(index + 1,false);
            stack.push(v);
        }

        return removed_item;
    }

    public static void main(String[] args) {
        int capacity_per_substack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 34; i++) {
            System.out.println("Popped " + set.pop());
        }
    }
}
