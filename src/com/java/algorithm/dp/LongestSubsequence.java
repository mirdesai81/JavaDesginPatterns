package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

public class LongestSubsequence {

    public static int longestSubsequence(String A,String B) {
        int[][] result = new int[A.length() + 1][B.length() + 1];
        int max = 0;

        for(int i = 1; i < result.length; i++) {
            for(int j = 1; j < result[i].length; j++) {

                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    result[i][j] = 1 + result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.max(result[i - 1][j] , result[i][j -1]);
                }
            }
        }

        return result[A.length()][B.length()];
    }

    public static void main(String[] args) {
        StdOut.println(longestSubsequence("abcdaf","acbcf"));
    }
}
