package com.java.algorithm.string;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.java.algorithm.string.StringPermutation.getPerms;

public class StringPermutation {


    public static ArrayList<String> permutation(String str) {
        if(str == null) return null;

        ArrayList<String> permutations = new ArrayList<String>();
        if(str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remaining = str.substring(1);
        ArrayList<String> words = permutation(remaining);

        for(String word : words) {
            for(int j = 0; j <= word.length(); j++) {
                String newStr = insertCharAt(word,first,j);
                permutations.add(newStr);
            }
        }

        return permutations;

    }

    public static ArrayList<String> permutationEfficient(String str) {
        ArrayList<String> result = new ArrayList<>();
        getPerms("",str,result);
        return result;
    }

    public static void getPerms(String prefix,String remainder, ArrayList<String> result) {
        if(remainder.length() == 0) result.add(prefix);

        int len = remainder.length();
        for(int i = 0; i < len; i++) {
            char c = remainder.charAt(i);
            String start = remainder.substring(0, i);
            String end = remainder.substring(i + 1);
            getPerms(prefix + c,start + end,result);
        }
    }

    public static ArrayList<String> permutationWithDuplicates(String str) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = freqTable(str);
        getPerms(map,"",str.length(),result);
        return result;
    }

    public static void getPerms(Map<Character,Integer> map,String prefix,int remaining,ArrayList<String> result) {
        if(remaining == 0) {
            result.add(prefix);
            return;
        }

        for( Character key : map.keySet()) {
            int count = map.get(key);
            if(count > 0) {
                map.put(key,count - 1);
                getPerms(map,prefix + key,remaining - 1,result);
                map.put(key,count);
            }
        }
    }

    public static HashMap<Character, Integer> freqTable(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        return map;
    }

    private static String insertCharAt(String word,char first,int index) {
        String start = word.substring(0,index);
        String end = word.substring(index);

        return start + first + end;
    }

    public static void main(String[] args) {
        StdOut.println(permutation("abcd"));
        StdOut.println(permutationEfficient("abcd"));
        StdOut.println(permutationWithDuplicates("aaa"));
    }
}
