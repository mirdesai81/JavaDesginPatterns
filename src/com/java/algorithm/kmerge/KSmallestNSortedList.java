package com.java.algorithm.kmerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestNSortedList {


    private static class Node {
        int elementIndex;
        int arrayIndex;

        Node(int arrayIndex,int elementIndex) {
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }


        public static int findKthSmallest(List<Integer[]> lists, int k) {
            // TODO: Write your code here
            PriorityQueue<Node> minHeap = new PriorityQueue<>(lists.size(),(n1 , n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

            for(int i = 0 ; i < lists.size(); i++) {
                if(lists.get(i) != null) {
                    minHeap.add(new Node(i,0));
                }
            }

            int count = 0;
            int result = -1;
            while(!minHeap.isEmpty()) {
                Node node = minHeap.poll();
                result = lists.get(node.arrayIndex)[node.elementIndex];
                if(++count == k) {
                    break;
                }


                minHeap.add(new Node(node.arrayIndex , node.elementIndex + 1));

            }


            return result;
        }

        public static void main(String[] args) {
            Integer[] l1 = new Integer[] { 2, 6, 8 };
            Integer[] l2 = new Integer[] { 3, 6, 7 };
            Integer[] l3 = new Integer[] { 1, 3, 4 };
            List<Integer[]> lists = new ArrayList<Integer[]>();
            lists.add(l1);
            lists.add(l2);
            lists.add(l3);
            int result = findKthSmallest(lists, 5);
            System.out.print("Kth smallest number is: " + result);
        }

}
