package com.java.algorithm.priorityQueue;

import java.util.*;

public class RearrangeStringWithDuplicatesKDistance {



        public static String reorganizeString(String str, int k) {
            // TODO: Write your code here
            Map<Character,Integer> frequency = new HashMap<>();
            PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a , b) -> b.getValue() - a.getValue());
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                frequency.put(ch,frequency.getOrDefault(ch,0) + 1);
            }

            maxHeap.addAll(frequency.entrySet());

            Map.Entry<Character,Integer> current = null;
            Queue<Map.Entry<Character,Integer>> queue = new LinkedList<>();
            StringBuilder result = new StringBuilder();
            while(!maxHeap.isEmpty()) {
                current = maxHeap.poll();
                result.append(current.getKey());
                current.setValue(current.getValue() - 1) ;
                queue.offer(current);

                if(queue.size() >= k) {
                    current = queue.poll();
                    if(current.getValue() > 0) {
                        maxHeap.offer(current);
                    }
                }
            }

            return (result.length() == str.length()) ? result.toString() : "";
        }

        public static void main(String[] args) {
            System.out.println("Reorganized string: " +
                    reorganizeString("mmpp", 2));
            System.out.println("Reorganized string: " +
                    reorganizeString("Programming", 3));
            System.out.println("Reorganized string: " +
                    reorganizeString("aab", 2));
            System.out.println("Reorganized string: " +
                    reorganizeString("aappa", 3));
        }

}
