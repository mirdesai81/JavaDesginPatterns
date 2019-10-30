package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {
    public static void updateMatrix(int[][] m) {
        boolean row_flag = false;
        boolean col_flag = false;
        List<List<Integer>> rowColIdList = new ArrayList<>();
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                if(i == 0 && m[i][j] == 0) {
                    row_flag = true;
                }

                if(j == 0 && m[i][j] == 0) {
                    col_flag = true;
                }

                if(m[i][j] == 0) {
                    m[0][j] = 0;
                    m[i][0] = 0;
                }
            }
        }

        // start from 1st row and 1st col
        for(int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if(m[0][j] == 0 || m[i][0] == 0) {
                    m[i][j] = 0;
                }
            }
        }

        if(row_flag) {
            for(int j = 0;j < m[0].length;j++) {
                m[0][j] = 0;
            }
        }

        if(col_flag) {
            for(int i = 0;i < m.length;i++) {
                m[i][0] = 0;
            }
        }

    }

    /* A utility function to print a 2D matrix */
    public static void printMatrix(int mat[][]){
        for (int i = 0; i < mat.length; i ++){
            for (int j = 0; j < mat[0].length; j ++){
                System.out.print( mat[i][j] + " " );
            }
            System.out.println("");
        }
    }

    // Driver function to test the above function
    public static void main(String args[] ){

        int mat[][] = {{10, 0,10, 10},
                {10, 10, 0, 10},
                {0, 10, 10, 10}};

        System.out.println("Input Matrix :");
        printMatrix(mat);

        updateMatrix(mat);

        System.out.println("Matrix After Update :");
        printMatrix(mat);

    }


}
