package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 4/30/2018.
 */
public class Palindrome {
    public static boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while(low < high) {
            if(s.charAt(low) != s.charAt(high)) {
                return false;
            }
            ++low;
            --high;
        }

        return true;
    }

    public static boolean isPalindromicAlphaNumeric(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {

            while(!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                ++i;
            }

            while(!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                --j;
            }

            if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(isPalindrome(s));

        System.out.println(isPalindromicAlphaNumeric("A man, a plan, a canal, Panama."));
        System.out.println(isPalindromicAlphaNumeric("Ray a Ray"));
        System.out.println(isPalindromicAlphaNumeric("Ray a   yaR"));
    }

}
