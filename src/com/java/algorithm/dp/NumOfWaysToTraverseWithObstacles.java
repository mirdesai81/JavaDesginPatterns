package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.Arrays;

public class NumOfWaysToTraverseWithObstacles {
    public static int numOfWays(boolean[][] obstacles) {
        int rows = obstacles.length;
        int cols = obstacles[0].length;
        int[][] result = new int[rows][cols];
        if(obstacles[0][0]) {
            return 0;
        } else {
            result[0][0] = 1;
        }


        for(int j = 1; j < cols; j++) {
            if(obstacles[0][j]) {
                result[0][j] = 0;
            } else {
                result[0][j] = result[0][j - 1];
            }
        }

        for(int i = 1; i < rows; i++) {
            if(obstacles[i][0]) {
                result[i][0] = 0;
            } else {
                result[i][0] = result[i - 1][0];
            }
        }

        for(int i = 1; i < rows; i++ ) {
            for(int j = 1; j < cols; j++) {
                if(!obstacles[i][j]) {
                    result[i][j] = result[i - 1][j] + result[i][j -1];
                }
            }
        }

        return result[rows - 1][cols - 1];

    }

    public static int numOfWaysEfficientSpace(boolean[][] obstacles,int shortSide,int longSide,boolean isRowsLong) {

        if(shortSide > longSide) {
            numOfWaysEfficientSpace(obstacles,longSide,shortSide,true);
        }

        int[] result = new int[shortSide];
        Arrays.fill(result,0);
        boolean isObstacle = false;
        for(int i = 0; i < longSide; i++) {
            for(int j = 0; j < shortSide; j++) {
                if(isRowsLong) {
                    isObstacle = obstacles[i][j];
                } else {
                    isObstacle = obstacles[j][i];
                }

                if(isObstacle) {
                    result[j] = 0;
                } else if(i == 0) {
                    if(j == 0) {
                        result[j] = 1;
                    } else {
                        result[j] = result[j - 1];
                    }
                } else if(j >= 1){

                    result[j] = result[j] + result[j - 1];
                }
            }
        }

        return result[shortSide - 1];
    }

    public static void main(String[] args) {
        boolean[][] obstacles = {{false,true,false,false,false},{false,false,true,false,false},{false,false,false,false,false},{false,false,false,false,false}};
        StdOut.println(numOfWays(obstacles));
        StdOut.println(numOfWaysEfficientSpace(obstacles,obstacles.length,obstacles[0].length,false));


        boolean[][] obstacles1 = {{false,true,false,false},{false,false,true,false},{false,false,false,false},{false,false,false,false},{false,false,false,false}};
        StdOut.println(numOfWays(obstacles1));
        StdOut.println(numOfWaysEfficientSpace(obstacles1,obstacles1.length,obstacles1[0].length,false));
    }
}
