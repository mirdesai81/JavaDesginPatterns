package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.*;
import java.util.stream.Collectors;

public class DecomposeIntoDictionaryWords {

    public static List<String> decomposeIntoDictionaryWords(String domain, Set<String> dictionary) {
        int[] lastLength = new int[domain.length()];
        Arrays.fill(lastLength, -1);

        for(int i = 0; i < domain.length(); i++) {
            if(dictionary.contains(domain.substring(0,i + 1))) {
                lastLength[i] = i + 1;
            }

            if(lastLength[i] == -1) {
                for(int j = 0; j < i; j++) {
                    if(lastLength[j] != -1 &&
                            dictionary.contains(domain.substring(j + 1, i + 1))) {
                        lastLength[j] = i - j;
                        break;
                    }
                }
            }
        }

        List<String> decompositions = new ArrayList<>();
        if(lastLength[lastLength.length - 1] != -1) {
            int idx = domain.length() - 1;
            while(idx >= 0) {
                decompositions.add(domain.substring(idx + 1 - lastLength[idx], idx + 1));
                idx = idx - lastLength[idx];
            }
            Collections.reverse(decompositions);
        }

        return decompositions;
    }

    public static void main(String[] args) {
        Set<String> dictionary = new LinkedHashSet<>();
        dictionary.add("a");
        dictionary.add("man");
        dictionary.add("a");
        dictionary.add("plan");
        dictionary.add("a");
        dictionary.add("canal");
        StdOut.println(decomposeIntoDictionaryWords("amanaplanacanal",dictionary));

    }
}
