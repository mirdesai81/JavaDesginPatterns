package com.java.algorithm.educative.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringKDistinct {

    public static int findLength(String s1,int k) {
        Map<Character,Integer> freq = new HashMap<>();
        int windowStart = 0;
        int maxLength = -1;
        int[] result = new int[2];
        for(int windowEnd = 0; windowEnd < s1.length(); windowEnd++) {
            Character ch = s1.charAt(windowEnd);
            freq.put(ch,freq.getOrDefault(ch,0) + 1);

            while(freq.size() > k) {
                Character left = s1.charAt(windowStart);
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
        System.out.println(s1.substring(result[0],result[1]));

        return maxLength > 0 ? maxLength : -1;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubStringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubStringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubStringKDistinct.findLength("cbbebi", 3));
    }
}
