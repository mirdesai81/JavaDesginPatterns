package com.java.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationOfTwoString {

    public static boolean checkPermutationOptimized(String s1,String s2) {
            if (s1.length() > s2.length())
                return false;
            int[] s1map = new int[26];
            int[] s2map = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                s1map[s1.charAt(i) - 'a']++;
                s2map[s2.charAt(i) - 'a']++;
            }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return Arrays.equals(s1map, s2map);
    }
   /* public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }*/

    public static boolean checkPermutation(String s1,String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();

        for(int i = 0; i < s1.length(); ++i) {

            s1Map.put(s1.charAt(i),s1Map.getOrDefault(s1.charAt(i),0) + 1);
            s2Map.put(s2.charAt(i),s2Map.getOrDefault(s2.charAt(i),0) + 1);
        }

        for(int i = 0; i <= s2.length() - s1.length();++i) {

            if(matches(s1Map,s2Map)) {
                return true;
            }


            s2Map.put(s2.charAt(i + s1.length()),s2Map.getOrDefault(s2.charAt(i + s1.length()),0) + 1);
            s2Map.put(s2.charAt(i),s2Map.getOrDefault(s2.charAt(i),1) - 1);
        }

        return matches(s1Map,s2Map);
    }

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

        System.out.println(checkPermutationOptimized(s1,s2));
    }
}
