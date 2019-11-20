package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.Arrays;

public class NumOfWaysToTraverse2DArray {

    public static int numOfWaysEfficientSpace(int n,int m) {
        if(n > m) {
            numOfWaysEfficientSpace(m,n);
        }

        int[] result = new int[n];
        Arrays.fill(result,1);

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                result[j] = result[j] + result[j -1];
            }
        }

        return result[n - 1];
    }

    public static int numOfWays(int n, int m) {
        int[][] result = new int[n][m];
        int cols = 0;
        int rows = 1;
        for(; cols < m; cols++) {
            result[0][cols] = 1;
        }

        for(; rows < n; rows++) {
            result[rows][0] = 1;
        }

        for(rows = 1; rows < n; rows++) {
            for(cols = 1; cols < m; cols++) {
                result[rows][cols] = result[rows - 1][cols] + result[rows][cols - 1];
            }
        }

        return result[n - 1][m - 1];
    }

    public static void main(String[] args) {
        StdOut.println(numOfWays(5,5));
        StdOut.println(numOfWaysEfficientSpace(5,5));
    }
}
