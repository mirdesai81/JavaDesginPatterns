package com.java.algorithm.string;

import java.util.Arrays;

public class CheckPermutation {
    public static final Integer CHAR_COUNT = 256;

    public static boolean checkPerm(String s1, String s2) {

        if(s1.length() != s2.length()) return false;

        int[] count = new int[CHAR_COUNT];
        Arrays.fill(count,0);
        int i;

        for(i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for(i = 0; i < CHAR_COUNT; i++) {
            if(count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPerm("test" , "estt"));
        System.out.println(checkPerm("test" , "eatt"));
    }
}
