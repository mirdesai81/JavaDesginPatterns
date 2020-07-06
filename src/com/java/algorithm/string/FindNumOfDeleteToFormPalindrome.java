package com.java.algorithm.string;

import com.java.stdlib.StdOut;

import java.util.Arrays;

public class FindNumOfDeleteToFormPalindrome {

    public static int minDeletion(String str,int i, int j, int[][] memo) {
        if(i >= j) return 0;

        if(memo[i][j] == -1) {
            if(str.charAt(i) == str.charAt(j)) {
                memo[i][j] = minDeletion(str,i + 1, j - 1,memo);
            } else {
                memo[i][j] = 1 + Math.min(minDeletion(str,i + 1, j,memo),minDeletion(str, i,j -1,memo));
            }
        }

        return memo[i][j];
    }

    public static int minDeletion(String str) {
        int[][] memo = new int[str.length() + 1][str.length() + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return minDeletion(str,0,str.length() - 1,memo);
    }

    public static void main(String[] args) {
        StdOut.println(minDeletion("ACBCDBAA"));
    }
}
