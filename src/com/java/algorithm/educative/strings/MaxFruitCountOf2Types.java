package com.java.algorithm.educative.strings;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        Map<Character,Integer> freq = new HashMap<>();
        int windowStart = 0;
        int maxLength = -1;
        int[] result = new int[2];
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            Character ch = arr[windowEnd];
            freq.put(ch,freq.getOrDefault(ch,0) + 1);

            while(freq.size() > 2) {
                Character left = arr[windowStart];
                freq.put(left,freq.get(left) - 1);

                if(freq.get(left) == 0) {
                    freq.remove(left);
                }
                windowStart++;
            }
            if(windowEnd - windowStart + 1 > maxLength) {
                result[0] = windowStart;
                result[1] = windowEnd + 1;
            }
            maxLength = Math.max(maxLength,windowEnd - windowStart + 1);
        }

        System.out.println("Range :"+result[0]+" - "+result[1]);
        for(int i = result[0]; i < result[1]; i++) {
            System.out.print(arr[i]);
        }


        System.out.println();
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
