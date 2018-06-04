package com.java.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfTwoString {

    public static boolean checkPermutation(String s1,String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

       /* int[] s1Map = new int[26];
        int[] s2Map = new int[26];*/

        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();

        for(int i = 0; i < s1.length(); ++i) {
           /* s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;*/
            s1Map.put(s1.charAt(i),s1Map.getOrDefault(s1.charAt(i),0) + 1);
            s2Map.put(s2.charAt(i),s2Map.getOrDefault(s2.charAt(i),0) + 1);
        }

        for(int i = 0; i <= s2.length() - s1.length();++i) {
            /*int[] s2Map = new int[26];
            for(int j = 0; j < s1.length();++j) {
                s2Map[s2.charAt(i + j) - 'a']++;
            }

            if(matches(s1Map,s2Map)) {
                return true;
            }*/
            if(matches(s1Map,s2Map)) {
                return true;
            }

            // increment the count for next character after s1.length()
            // decrement the count for ith character in s2 for sliding window
            /*s2Map[s2.charAt(i + s1.length()) - 'a']++;
            s2Map[s2.charAt(i) - 'a']--;*/

            s2Map.put(s2.charAt(i + s1.length()),s2Map.getOrDefault(s2.charAt(i + s1.length()),0) + 1);
            s2Map.put(s2.charAt(i),s2Map.getOrDefault(s2.charAt(i),1) - 1);
        }

        return matches(s1Map,s2Map);
    }

   /* public static boolean matches(int[] s1Map,int[] s2Map) {
        for(int i = 0; i < 26;++i) {
            if(s1Map[i] != s2Map[i]) {
                return false;
            }
        }

        return true;
    }*/

    public static boolean matches(Map<Character,Integer> s1Map,Map<Character,Integer> s2Map) {
        for(Map.Entry<Character,Integer> s1 : s1Map.entrySet()) {
            if(!s2Map.containsKey(s1.getKey()) || !s2Map.get(s1.getKey()).equals(s1.getValue())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1= "abc";
        String s2 = "assbacadef";

        System.out.println(checkPermutation(s1,s2));
    }
}
