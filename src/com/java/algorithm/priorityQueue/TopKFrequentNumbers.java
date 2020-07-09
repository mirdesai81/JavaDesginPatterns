package com.java.algorithm.priorityQueue;

import java.util.*;

public class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(k,(a , b) -> a.getValue() - b.getValue());
        for(int i = 0 ; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i],0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.add(entry);
            } else {
                if(minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }

        }

        List<Integer> topNumbers = new ArrayList<>(k);
        // TODO: Write your code here
        while(!minHeap.isEmpty()) {
            Map.Entry<Integer,Integer> entry = minHeap.poll();
            topNumbers.add(entry.getKey());
        }

        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
