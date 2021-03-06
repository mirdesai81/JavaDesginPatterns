package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

public class LongestPalindromeSubsequence {

   /* public static int longestPalindromeSubsequence(String A) {
        int[][] result = new int[A.length()][A.length()];
        for(int i = 0; i < A.length(); i++) {
            result[i][i] = 1;
        }

        for(int l = 2; l <= A.length(); l++) {
            for(int i = 0; i < A.length() - l + 1; i++) {
                int j = i + l - 1;
                if(l == 2 && A.charAt(i) == A.charAt(j)) {
                    result[i][j] = 2;
                } else if (A.charAt(i) == A.charAt(j)) {
                    result[i][j] = result[i + 1][j - 1] + 2;
                } else {
                    result[i][j] = Math.max(result[i + 1][j],result[i][j - 1]);
                }
            }
        }

        return result[0][A.length() - 1];
    }
*/

    public static int longestPalindromeSubsequence(String A) {
        int n = A.length();
        int[][] memo = new int[n + 1][n + 1];
        String B = new StringBuilder(A).reverse().toString();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j],memo[i][j - 1]);
                }
            }
        }

        return memo[n][n];
    }



    public static int numOfCharactersToDeleteToFormPalindrome(String s) {
        return s.length() - longestPalindromeSubsequence(s);
    }

    public static void main(String[] args) {
        StdOut.println(longestPalindromeSubsequence("agbdba"));
        StdOut.println(numOfCharactersToDeleteToFormPalindrome("agbdba"));
    }
}
