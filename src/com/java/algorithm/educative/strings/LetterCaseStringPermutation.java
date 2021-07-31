package com.java.algorithm.educative.strings;

import java.util.*;

class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for(int i = 0; i < str.length(); i++) {

            if(Character.isLetter(str.charAt(i))) {
                int n = permutations.size();
                for(int j = 0; j < n; j++) {
                    char[] ch = permutations.get(j).toCharArray();
                    if(Character.isLowerCase(ch[i])) {
                        ch[i] = Character.toUpperCase(ch[i]);
                    } else {
                        ch[i] = Character.toLowerCase(ch[i]);
                    }
                    permutations.add(String.valueOf(ch));
                }
            }

        }
        // TODO: Write your code here
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}

