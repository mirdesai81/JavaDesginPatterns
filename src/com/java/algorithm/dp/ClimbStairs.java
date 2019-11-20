package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

public class ClimbStairs {

    public static int countWaysHelper(int n,int m) {
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;

        for(int i = 2; i < n; i++) {
            result[i] = 0;
            for(int j = 1; j <= m && j <= i;j++) {
                result[i] += result[i - j];
            }
        }

        return result[n - 1];
    }

    public static int countWays(int s,int m) {
        return countWaysHelper(s + 1,m);
    }

    public static void main(String[] args) {
        StdOut.println(countWays(10,3));
    }
}
