package com.java.algorithm.educative.array;

import java.util.*;

public class GroupAnagrams {

    public static String groupAnagrams(String arr[]) {
        HashMap < String, List < String >> myMap = new HashMap< >();
        //write your code here

        for(String str : arr) {
            char[] charArray = new char[str.length()];
            charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if(myMap.containsKey(sortedString)) {
                myMap.get(sortedString).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                myMap.put(sortedString,list);
            }
        }



        String anagrams = "";
        for(Map.Entry<String, List<String>> entry : myMap.entrySet()) {
            anagrams += entry.getValue();
        }

        return anagrams;
    }

    public static void main(String[] args) {
        String arr[] = {
                "cat",
                "dog",
                "tac",
                "god",
                "act",
                "tom marvolo riddle ",
                "abc",
                "def",
                "cab",
                "fed",
                "clint eastwood ",
                "i am lord voldemort",
                "elvis",
                "old west action",
                "lives"
        };
        System.out.println(groupAnagrams(arr));
    }
}
