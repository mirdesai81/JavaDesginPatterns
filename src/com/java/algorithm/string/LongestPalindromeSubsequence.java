package com.java.algorithm.string;

public class LongestPalindromeSubsequence {


    /*
     * Complete the 'getScore' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int getScore(String s) {
        // Write your code here
        int len = s.length();
        int maxScore = 0;
        int T[][] = new int[len][len];

        // for each character mark as 1
        for(int i = 0; i < len; i++) {
            T[i][i] = 1;
        }

        for(int l = 2; l <= len; l++ ) {
            for(int i = 0; i < len - l + 1; i++ ) {
                int j = i + l - 1;
                if(l == 2 && s.charAt(i) == s.charAt(j)) {
                    T[i][j] = 2;
                } else if(s.charAt(i) == s.charAt(j)) {
                    T[i][j] = T[i + 1][j - 1] + 2;
                } else {
                    T[i][j] = Math.max(T[i + 1][j] , T[i][j - 1]);
                }
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len - 1;j++) {
                maxScore = Math.max(maxScore,T[i][j] * T[j + 1][len - 1]);
            }
        }


        return maxScore;
    }
}
