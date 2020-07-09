package com.java.algorithm.priorityQueue;

import java.util.PriorityQueue;

public class ConnectRopes {


        public static int minimumCostToConnectRopes(int[] ropeLengths) {
            // TODO: Write your code here
            PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
            for(int i = 0 ; i < ropeLengths.length; i++) {
                minHeap.add(ropeLengths[i]);
            }

            int temp = 0;
            int result = 0;
            while(minHeap.size() > 1) {
                temp = minHeap.poll() + minHeap.poll();
                result += temp;
                minHeap.add(temp);
            }

            return result;
        }

        public static void main(String[] args) {
            int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
            System.out.println("Minimum cost to connect ropes: " + result);
            result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
            System.out.println("Minimum cost to connect ropes: " + result);
            result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
            System.out.println("Minimum cost to connect ropes: " + result);
        }


}
