package com.java.algorithm.educative.heap;

import java.util.*;

class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        // TODO: Write your code here

        for(int i = 0;i < nums.length; i++) {
            if(maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            reBalanceHeaps();

            // Reached K from i = 0
            if(i - k + 1 >= 0) {
                if(maxHeap.size() == minHeap.size()) {
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }

                // remove outgoing number starting from 0
                int elementToRemove = nums[i - k + 1];
                if(maxHeap.peek() >= elementToRemove) {
                    maxHeap.remove(elementToRemove);
                } else {
                    minHeap.remove(elementToRemove);
                }

                reBalanceHeaps();
            }


        }

        return result;
    }

    public void reBalanceHeaps() {
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}
