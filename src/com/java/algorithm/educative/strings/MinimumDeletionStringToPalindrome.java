package com.java.algorithm.educative.strings;

public class MinimumDeletionStringToPalindrome {

    public static int  findMinimumDeletions(String str) {
        return str.length() - LSPLength(str);
    }

    public static int LSPLength(String str) {
        return LSPLength(new int[str.length()][str.length()],str);
    }

    private static int LSPLength(int[][] dp,String str) {
        // string of length 1 is palindrome
        for(int i = 0; i < str.length(); i++){
            dp[i][i] = 1;
        }

        for(int startIdx = str.length() - 1; startIdx >= 0; startIdx--) {
            for(int endIdx = startIdx + 1; endIdx < str.length() ; endIdx++) {
               if(str.charAt(startIdx) == str.charAt(endIdx)) {
                   dp[startIdx][endIdx] = 2 + dp[startIdx + 1][endIdx - 1];
               } else {
                   dp[startIdx][endIdx] = Math.max(dp[startIdx + 1][endIdx], dp[startIdx][endIdx - 1]);
               }
            }
        }

        return dp[0][str.length() - 1];
    }

    public static void main(String[] args) {

        System.out.println(findMinimumDeletions("abdbca"));
        System.out.println( findMinimumDeletions("cddpd"));
        System.out.println(findMinimumDeletions("pqr"));
    }
}
