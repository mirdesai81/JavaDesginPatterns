package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.Arrays;

public class CountDistinctSubsequence {

    public static int countDistinctSubsequence(String A) {
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int[] result = new int[A.length() + 1];
        // empty string has only one subsequnce
        result[0] = 1;
        int n = A.length();
        for(int i = 1; i <= n; i++) {
            result[i] = 2 * result[i - 1];

            if(last[A.charAt(i - 1)] != -1) {
                result[i] = result[i] - result[last[A.charAt(i - 1)]];
            }

            last[A.charAt(i - 1)] = i - 1;
        }

        return result[n];
    }

    public static void main(String[] args) {
        StdOut.println(countDistinctSubsequence("gfg"));
    }
}
