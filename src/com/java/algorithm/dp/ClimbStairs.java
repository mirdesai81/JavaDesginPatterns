package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.Arrays;

public class ClimbStairs {

    public static int countWaysHelper(int n,int m) {
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;

        for(int i = 2; i <= n; i++) {
            result[i] = 0;
            for(int j = 1; j <= m && j <= i;j++) {
                result[i] += result[i - j];
            }
        }

        return result[n];
    }

    public static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n,memo);
    }

    public static int countWays(int n, int[] memo) {
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        } else if(memo[n] != -1) {
            return memo[n];
        } else {
            return countWays(n - 1,memo) + countWays(n - 2,memo) + countWays(n - 3, memo);
        }
    }

    public static int countWays(int s,int m) {
        return countWaysHelper(s,m);
    }

    public static void main(String[] args) {
        StdOut.println(countWays(10,3));
        StdOut.println(countWays(10));
    }
}
