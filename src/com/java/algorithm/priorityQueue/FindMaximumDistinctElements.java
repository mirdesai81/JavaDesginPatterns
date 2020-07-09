package com.java.algorithm.priorityQueue;

import java.util.*;

public class FindMaximumDistinctElements {


        public static int findMaximumDistinctElements(int[] nums, int k) {
            // TODO: Write your code here

            int distinctCount = 0;
            List<Integer> result = new ArrayList<>();
            Map<Integer,Integer> frequency = new HashMap<>();
            PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
            for(int i = 0 ; i < nums.length; i++) {
                frequency.put(nums[i], frequency.getOrDefault(nums[i],0) + 1);
            }

            for(Map.Entry<Integer,Integer> entry : frequency.entrySet()) {
                if(entry.getValue() == 1) {
                    distinctCount++;
                    result.add(entry.getKey());
                } else {
                    minHeap.add(entry);
                }
            }

            while(k > 0 && !minHeap.isEmpty()) {
                Map.Entry<Integer,Integer> min = minHeap.poll();
                k = k - min.getValue() + 1;

                if(k > 0) {
                    distinctCount++;
                    result.add(min.getKey());
                }
            }

            if(k > 0) {
                distinctCount = distinctCount - k;
            }

            System.out.println(result.subList(0,distinctCount));


            return distinctCount;
        }

        public static void main(String[] args) {
            int result = findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
            System.out.println("Maximum distinct numbers after removing K numbers: " + result);

            result = findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
            System.out.println("Maximum distinct numbers after removing K numbers: " + result);

            result = findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
            System.out.println("Maximum distinct numbers after removing K numbers: " + result);
        }

}
