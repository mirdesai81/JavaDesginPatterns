package com.java.algorithm.priorityQueue;

import com.java.stdlib.StdOut;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StackMaxHeap {

    private static class HeapEntry {
        public Integer rank;
        public Integer value;

        public HeapEntry(Integer rank, Integer value) {
            this.rank = rank;
            this.value = value;
        }
    }

    private static class Compare implements Comparator<HeapEntry> {
        @Override
        public int compare(HeapEntry o1, HeapEntry o2) {
            return Integer.compare(o2.rank,o1.rank);
        }

        public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
    }

    public static class Stack {
        private int timestamp = 0;
        private PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>(16,Compare.COMPARE_HEAP_ENTRIES);

        public void push(Integer x) {
            maxHeap.add(new HeapEntry(timestamp++,x));
        }

        public Integer pop() {
            return maxHeap.remove().value;
        }

        public Integer peek() {
            return maxHeap.peek().value;
        }

    }

    public static  void main(String[] args) {
        Stack stack = new Stack();
        stack.push(12);
        stack.push(13);
        stack.push(14);

        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
    }
}
