package com.java.algorithm.priorityQueue;

import com.java.stdlib.StdOut;

import java.util.*;

public class SequenceMedian {

    public static  List<Double> findMedianSequence(List<Integer> sequence) {
        Iterator<Integer> iter = sequence.iterator();
        List<Double> result = new ArrayList<>();
        // store the larger half seen so far
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // store the smaller half seen so far
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16,Collections.reverseOrder());

        while(iter.hasNext()) {
            int x = iter.next();
            if(minHeap.isEmpty()) {
                minHeap.add(x);
            } else {
                if(x >= minHeap.peek()) {
                    minHeap.add(x);
                } else {
                    maxHeap.add(x);
                }
            }

            // Ensure minHeap and maxHeap have equal number of elements if
            // an even number of elements is read; otherwise , minHeap must have
            // one more element than maxHeap.
            if(minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.remove());
            } else if(maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }

            result.add(minHeap.size() == maxHeap.size() ? 0.5 * (minHeap.peek() + maxHeap.peek()) : Double.valueOf(minHeap.peek()));
        }


        return result;
    }

    public static void main(String[] args) {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1,0,3,5,2,0,1));
        StdOut.println(findMedianSequence(sequence));
    }
}
