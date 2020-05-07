package com.java.algorithm.stack;

import com.java.stdlib.StdOut;

import java.util.Stack;

public class SortStack {

    public static void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();

        while(!s.isEmpty()) {
            Integer temp = s.pop();
            while (!r.isEmpty() && temp.compareTo(r.peek()) < 0) {
                s.push(r.pop());
            }
            r.push(temp);
        }

        while(!r.isEmpty()) {
            s.push(r.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(12);
        s.push(10);
        s.push(3);
        s.push(4);

        sort(s);

        while(!s.isEmpty()) {
            StdOut.println("Popped -"+s.pop());
        }
    }
}
