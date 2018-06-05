package com.java.algorithm.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Created by Mihir.Desai on 3/22/2017.
 */
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] item;

    int N = 0;

    public ResizingArrayStack(int capacity) {
        item = (T[]) new Object[capacity];

    }

    public ResizingArrayStack() {
        item = (T[])new Object[1];

    }


    private void resize(int max){
        T[] temp = (T[])new Object[max];
        for(int i = 0; i < N; i++) {
            temp[i] = item[i];
        }

        item = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T item) {
        //resize
        if(N == this.item.length) {
            resize(2*this.item.length);
        }
        this.item[N++] = item;
    }

    public T pop() {
        T a = peek();
        item[--N] = null;

        //resize to half if quarter full
        if(N>0 && N == item.length/4) resize(item.length/2);
        return a;
    }

    public T peek() {
        /*int size = size();*/
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        return item[N - 1];
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return item[--i];
        }

        @Override
        public void remove() {

        }


    }

    public static void main(String args[]) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        String[] data = new String[]{"to","be","-","or","to","not","-","-","that","-","-","-"};
        for(String s : data) {
            if(!s.equals("-"))
                stack.push(s);
            else  {
                System.out.println(stack.pop());
            }
        }

        System.out.println("Size left on queue - "+stack.size());

        Iterator<String> it = stack.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        ResizingArrayStack<Integer> stack1 = new ResizingArrayStack<>();
        int N = 50;
        while(N > 0) {
            stack1.push(N%2);
            N = N/2;
        }

        System.out.println(stack1.peek());

        Iterator<Integer> it1 = stack1.iterator();
        while(it1.hasNext()) {
            System.out.print(it1.next());
        }

    }
}
