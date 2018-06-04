package com.java.algorithm.string;

public class PalindromePermutation {

    public static boolean isPermutationPalindrome(String s) {
        int[] map = new int[256];
        int count = 0;

        for(int i = 0; i < s.length(); ++i) {
            map[s.charAt(i)]++;
            if(map[s.charAt(i)] % 2 == 0) {
                count--;
            } else {
                count++;
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println("CODE - " + isPermutationPalindrome("CODE"));
        System.out.println("AAB - " + isPermutationPalindrome("AAB"));
    }
}
