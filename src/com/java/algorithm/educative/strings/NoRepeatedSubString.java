package com.java.algorithm.educative.strings;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatedSubString {
    public static int noRepeat(String s) {
        Map<Character,Integer> charMap = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;
        int result[] = new int[2];
        for(int windowEnd = 0; windowEnd < s.length();windowEnd++) {
            char right = s.charAt(windowEnd);
            // shrink the window if duplicate found
            if(charMap.containsKey(right)) {
                windowStart = Math.max(windowStart,charMap.get(right) + 1);
            }

            charMap.put(right,windowEnd);
            if(windowEnd - windowStart + 1 > maxLength) {
                result[0] = windowStart;
                result[1] = windowEnd + 1;
            }
            maxLength = Math.max(maxLength,windowEnd - windowStart + 1);
        }

        System.out.println(s.substring(result[0],result[1]));
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + noRepeat("aabccbb"));
        System.out.println("Length of the longest substring: " + noRepeat("abbbb"));
        System.out.println("Length of the longest substring: " + noRepeat("abccde"));
    }
}
