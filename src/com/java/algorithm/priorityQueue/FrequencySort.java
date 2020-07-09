package com.java.algorithm.priorityQueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {



        public static String sortCharacterByFrequency(String str) {
            // TODO: Write your code here
            Map<Character,Integer> frequency = new HashMap<>();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                frequency.put(ch,frequency.getOrDefault(ch,0) + 1);
            }

            PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((s1, s2) -> s2.getValue() - s1.getValue());
          /*  for(Map.Entry<Character,Integer> entry : frequency.entrySet()) {
                maxHeap.add(entry);
            }*/

            maxHeap.addAll(frequency.entrySet());

            StringBuilder result = new StringBuilder();

            while(!maxHeap.isEmpty()) {
                Map.Entry<Character,Integer> charEntry = maxHeap.poll();
                int count = 0;
                while(charEntry != null && count < charEntry.getValue()) {
                    result.append(charEntry.getKey());
                    count++;
                }
            }

            return result.toString();
        }

        public static void main(String[] args) {
            String result = FrequencySort.sortCharacterByFrequency("Programming");
            System.out.println("Here is the given string after sorting characters by frequency: " + result);

            result = FrequencySort.sortCharacterByFrequency("abcbab");
            System.out.println("Here is the given string after sorting characters by frequency: " + result);
        }


}
