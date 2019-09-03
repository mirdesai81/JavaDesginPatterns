package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/10/2018.
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
       int maxPalindrome = 0;
       String palindrome;
        String currPalindromeString;

       for(int i = 0; i < s.length() - 1;i++) {
           int left = i - 1;
           int right = i + 1;
           int currPalindrome = 1;
           StringBuilder oddPalindrome = new StringBuilder();
           oddPalindrome.append(s.charAt(i));
           StringBuilder evenPalindrome = new StringBuilder();
           evenPalindrome.append(s.charAt(i)).append(s.charAt(i + 1));

           // odd
           while(left >= 0 && right <= s.length() - 1) {
               if(s.charAt(left) != s.charAt(right)) {
                   break;
               }

               currPalindrome += 2;
               currPalindromeString = oddPalindrome.toString();
               oddPalindrome = new StringBuilder();
               oddPalindrome.append(s.charAt(left)).append(currPalindromeString).append(s.charAt(right));
               --left;
               ++right;
           }

           if(currPalindrome > maxPalindrome) {
               maxPalindrome = currPalindrome;
               palindrome = oddPalindrome.toString();
               System.out.println("Current Longest Palindrome for odd - "+palindrome);
           }

           // even
           if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
               left = i - 1;
               right = i + 2;
               currPalindrome = 2;

               while(left >= 0 && right <= s.length() - 1) {
                   if(s.charAt(left) != s.charAt(right)) {
                       break;
                   }

                   currPalindrome = currPalindrome + 2;
                   currPalindromeString = evenPalindrome.toString();
                   evenPalindrome = new StringBuilder();
                   evenPalindrome.append(s.charAt(left)).append(currPalindromeString).append(s.charAt(right));
                   --left;
                   ++right;
               }

               if(currPalindrome > maxPalindrome) {
                   maxPalindrome = currPalindrome;
                   palindrome = evenPalindrome.toString();
                   System.out.println("Current Longest Palindrome for even - "+palindrome);
               }
           }

       }


        return maxPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbacab"));
        System.out.println(longestPalindrome("abababa"));
        System.out.println(longestPalindrome("abbab"));
    }
}
