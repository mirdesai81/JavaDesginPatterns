package com.java.algorithm.priorityQueue;

import java.util.PriorityQueue;

public class FindSumFromK1ToK2Smallest {


        public static int findSumOfElements(int[] nums, int k1, int k2) {
            // TODO: Write your code here
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                if(i < k2 - 1) {
                    maxHeap.add(nums[i]);
                } else  {
                    if(nums[i] < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.add(nums[i]);
                    }
                }

            }


            for(int i = 0; i < k2 - k1 - 1; i++) {
                sum += maxHeap.poll();
            }

            return sum;
        }

        public static void main(String[] args) {
            int result = findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
            System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

            result = findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
            System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
        }

}
