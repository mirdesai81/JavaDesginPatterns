package com.java.algorithm.hashtable;

import com.java.stdlib.StdOut;

import java.util.HashMap;
import java.util.Map;

public class StringCanFormPalindrome {

    public static boolean canFormPalindrome(String s) {
        Map<Character,Integer> charFrequencies = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!charFrequencies.containsKey(c)) {
                charFrequencies.put(c,1);
            } else {
                charFrequencies.put(c,charFrequencies.getOrDefault(c,0) + 1);
            }

        }

        // A string can be permuted to a palindrome if and only if
        // the number of chars whose frequencies is odd is at most 1.
        int oddCount = 0;
        for(Map.Entry<Character,Integer> p : charFrequencies.entrySet()) {
            if((p.getValue() % 2 != 0) && ++oddCount > 1) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        StdOut.println(canFormPalindrome("edified"));
        StdOut.println(canFormPalindrome("edifiedfdi"));
    }
}
