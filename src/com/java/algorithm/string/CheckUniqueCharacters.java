package com.java.algorithm.string;

import java.util.Arrays;

public class CheckUniqueCharacters {

    public static boolean checkUniqueCharacters(String str) {
        int checker = 0;

        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((checker & ( 1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }

        return true;
    }

    public static boolean checkUniqueCharactersWithCountArray(String str) {
        int checker = 0;
        boolean[] chars = new boolean[256];
        Arrays.fill(chars,false);
        if(str.length() > 256) {
            return false;
        }

        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);

            if(chars[index]) {
                return false;
            }

            chars[index] = true;
        }

        return true;
    }

    public static boolean checkUniqueCharactersWithSort(String str) {
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);

        for(int i = 0; i < str.length() - 1; i++) {
           if(strArray[i] == strArray[i + 1]) {
               return false;
           }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(checkUniqueCharacters("abcdefghijka"));
        System.out.println(checkUniqueCharacters("abcdefghijk"));

        System.out.println(checkUniqueCharactersWithCountArray("Abcdefghijka"));
        System.out.println(checkUniqueCharactersWithSort("abcdefghijkl"));
    }
}
