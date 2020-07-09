package com.java.algorithm.priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringNoDuplicatesAdjacent {



        public static String rearrangeString(String str) {
            // TODO: Write your code here
            Map<Character,Integer> frequency = new HashMap<>();
            PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                frequency.put(ch,frequency.getOrDefault(ch,0) + 1);
            }

            maxHeap.addAll(frequency.entrySet());

            Map.Entry<Character,Integer> previous = null;
            StringBuilder result = new StringBuilder();
            while(!maxHeap.isEmpty()) {
                Map.Entry<Character,Integer> current = maxHeap.poll();

                if(previous != null && previous.getValue() > 0) {
                    maxHeap.offer(previous);
                }

                result.append(current.getKey());
                current.setValue(current.getValue() - 1);
                previous = current;

            }

            return result.length() == str.length() ? result.toString() : "";
        }

        public static void main(String[] args) {
            System.out.println("Rearranged string: " + rearrangeString("aappp"));
            System.out.println("Rearranged string: " + rearrangeString("Programming"));
            System.out.println("Rearranged string: " + rearrangeString("aapa"));
        }

}
