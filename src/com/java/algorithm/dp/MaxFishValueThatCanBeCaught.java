package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

public class MaxFishValueThatCanBeCaught {
    public static int maxFishValueCaught(int[][] sea) {
        int rows = sea.length;
        int cols = sea[0].length;
        int[][] result = new int[rows][cols];
        result[0][0] = sea[0][0];

        for(int j = 1; j < cols; j++) {
            result[0][j] = result[0][j - 1] + sea[0][j];
        }

        for(int i = 1; i < rows; i++) {
            result[i][0] = result[i -1][0] + sea[i][0];
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols;j++) {
                result[i][j] = Math.max(result[i][j -1], result[i - 1][j]) + sea[i][j];
            }
        }

        return result[rows - 1][cols - 1];
    }


    public static void main(String[] args) {
        int[][] sea = {{10,5,15,10,5},{5,15,10,15,5},{15,5,5,5,15}};
        StdOut.println(maxFishValueCaught(sea));
    }
}
