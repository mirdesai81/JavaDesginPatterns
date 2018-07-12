package com.java.algorithm.hashtable;

import com.java.stdlib.StdOut;

import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    public static List<List<String>> findAnagrams(List<String> dictionary) {

        Map<String,List<String>> sortedStringToAnagrams = new HashMap<>();

        for(String s : dictionary) {
            char[] sortedArray = s.toCharArray();
            Arrays.sort(sortedArray);
            String sortedString = new String(sortedArray);

            if(!sortedStringToAnagrams.containsKey(sortedString)) {
                sortedStringToAnagrams.put(sortedString,new ArrayList<>());
            }

            sortedStringToAnagrams.get(sortedString).add(s);
        }

       /* List<List<String>> anagramGroups = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : sortedStringToAnagrams.entrySet()) {

            if(entry.getValue().size() >= 2) {
                anagramGroups.add(entry.getValue());
            }
        }*/

        List<List<String>> anagramGroups = sortedStringToAnagrams.entrySet().stream().filter(entry -> entry.getValue().size() >= 2).
                map(Map.Entry::getValue).collect(Collectors.toList());

        return anagramGroups;

    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>(Arrays.asList("debitcard", "elvis", "silent", "badcredit", "lives",
                "freedom", "listen", "levis", "money"));
        StdOut.println(findAnagrams(dictionary));
    }

}
