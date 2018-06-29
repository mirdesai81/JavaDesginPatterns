package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search2DSortedArray {

    public static boolean search2DArray(List<List<Integer>> A,int k) {
        int row = 0;
        int col = A.get(0).size() - 1;

        while(row < A.size() && col >= 0) {

            if(A.get(row).get(col).equals(k)) {
                StdOut.println("row - "+row+",col - "+col);
                return true;
            } else if(A.get(row).get(col) < k) {
                // last remaining column of every row
                // eliminate row
                row++;
            } else {
                // eliminate col
                col--;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> sorted2D = new ArrayList<>();
        sorted2D.add(new ArrayList<>(Arrays.asList(-1, 2, 4, 4, 6)));
        sorted2D.add(new ArrayList<>(Arrays.asList(1, 5, 5, 9, 21)));
        sorted2D.add(new ArrayList<>(Arrays.asList(3, 6, 6, 9, 22)));
        sorted2D.add(new ArrayList<>(Arrays.asList(3, 6, 8, 10, 24)));
        sorted2D.add(new ArrayList<>(Arrays.asList(6, 8, 9, 12, 25)));
        sorted2D.add(new ArrayList<>(Arrays.asList(8, 10, 12, 14, 40)));

        StdOut.println(search2DArray(sorted2D,14));
    }
}
