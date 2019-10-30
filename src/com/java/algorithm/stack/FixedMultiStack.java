package com.java.algorithm.stack;

public class FixedMultiStack {
    int[] values;
    int[] sizes;
    private int numerofStacks = 3;
    private int stackCapacity;

    public FixedMultiStack(int capacity) {
        this.stackCapacity = capacity;
        this.values = new int[numerofStacks * capacity];
        this.sizes = new int[numerofStacks];
    }

    public int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];

        return offset + size - 1;
    }

    public void push(int stackNum,int value) {
        if(isFull(stackNum)) {
            throw new IllegalStateException(String.format("Stack %d is full",stackNum));
        }

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;

    }

    public int peek(int stackNum) {
        if(isEmpty(stackNum)) throw new IllegalStateException(String.format("Stack %d is empty",stackNum));

        return values[indexOfTop(stackNum)];
    }

    public int pop(int stackNum) {
        if(isEmpty(stackNum)) throw new IllegalStateException(String.format("Stack %d is empty",stackNum));
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public static void main(String[] args) {
        FixedMultiStack fixedMultiStack = new FixedMultiStack(10);
        fixedMultiStack.push(1,11);
        fixedMultiStack.push(2,21);
        fixedMultiStack.push(3,31);
    }
}
