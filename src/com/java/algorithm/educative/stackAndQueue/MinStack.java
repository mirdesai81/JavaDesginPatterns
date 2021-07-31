package com.java.algorithm.educative.stackAndQueue;

public class MinStack {

    class ArrayReader {
        int min;
        int value;

        public ArrayReader(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    int maxSize;
    int min;
    ArrayReader[] reader;
    int top;
    int size;
    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        reader = new ArrayReader[maxSize];
        min = Integer.MAX_VALUE;
        top = -1;
        this.maxSize = maxSize;
        size = 0;
    }

    public ArrayReader top() {
        if(isEmpty()) return null;

        return reader[top];
    }

    //removes and returns value from stack
    public Integer pop(){
        // Write -- Your -- Code
        if(isEmpty()) return -1;
        ArrayReader val = reader[top];
        top--;

        if(val.min == min) {
            min = top().min;
        }
        return val.value;
    }
    //pushes value into the stack
    public void push(Integer value){
        // Write -- Your -- Code
        if(isFull()) return;
        if(value < min) {
            min = value;
        }

        reader[++top] = new ArrayReader(value,min);
    }
    //returns minimum value in O(1)
    public int min(){
        // Write -- Your -- Code
        return min;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String args[]) {

        MinStack stack = new MinStack(6);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(9);

        System.out.println(stack.min());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.min());

    }
}

