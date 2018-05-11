package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/10/2018.
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        int maxPalindrome = 0;
        String palindrome = "";
        // odd length
        for(int i = 0;i < s.length() - 1; ++i) {
            int left = i - 1;
            int right = i + 1;
            int currPalindrome = 1;
            String oddPalindrome = "" + s.charAt(i);
            String evenPalindrome = "" + s.charAt(i) + s.charAt(i+1);
            while(left >= 0 && right <= s.length() - 1) {
                if(s.charAt(left) != s.charAt(right)) {
                    break;
                }

                currPalindrome += 2;
                oddPalindrome = ("" + s.charAt(left)) + oddPalindrome + ("" + s.charAt(right));
                --left;
                ++right;
            }

            if(currPalindrome > maxPalindrome) {
                maxPalindrome = currPalindrome;
                palindrome = oddPalindrome;
            }

            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                left = i - 1;
                right = i + 2;
                currPalindrome = 2;

                while(left >= 0 && right <= s.length() - 1) {
                    if(s.charAt(left) != s.charAt(right)) {
                        break;
                    }

                    currPalindrome += 2;
                    evenPalindrome = ("" + s.charAt(left)) + evenPalindrome + ("" + s.charAt(right));
                    --left;
                    ++right;
                }

                if(currPalindrome > maxPalindrome) {
                    maxPalindrome = currPalindrome;
                    palindrome = evenPalindrome;
                }
            }

            System.out.println("Palindrome - "+ palindrome);
        }

        return maxPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbacab"));
        System.out.println(longestPalindrome("abababa"));
        System.out.println(longestPalindrome("abbab"));
    }
}
