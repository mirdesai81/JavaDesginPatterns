package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

public class ComputeBinomialCoefficient {
    public static int computeBinomialCoefficient(int n, int k) {
       return computeXChooseY(n,k,new int[n + 1][k + 1]);
    }

    private static int computeXChooseY(int x, int y,int[][] result) {
        /*if(y == 0 || x == y ){
            return 1;
        }

        if(result[x][y] == 0) {

        }*/

        for(int i = 0; i <= x; i++) {
            for(int j = 0; j <= Math.min(i,y); j++) {
                    if(j == 0 || i == j) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
                    }

            }
        }

        return result[x][y];
    }

    public static void main(String[] args) {
        StdOut.println(computeBinomialCoefficient(5,2));
    }

}
