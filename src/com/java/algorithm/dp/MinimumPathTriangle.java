package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumPathTriangle {

    public static int minimumPathTotal(List<List<Integer>> triangle) {
        List<Integer> prevRow = new ArrayList<>(triangle.get(0));

        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> currRow = new ArrayList<>(triangle.get(i));
            // 1st item of each row
            currRow.set(0,currRow.get(0) + prevRow.get(0));

            // middle items of each item come from prevRows j - 1 and j entry
            for(int j = 1; j < currRow.size() - 1; j++) {
                currRow.set(j, currRow.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
            }

            // last item of each row
            currRow.set(currRow.size() - 1, currRow.get(currRow.size() - 1) + prevRow.get(prevRow.size() - 1));
            prevRow = currRow;
        }

        return Collections.min(prevRow);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(4,4));
        triangle.add(Arrays.asList(8,5,6));
        triangle.add(Arrays.asList(4,2,6,2));
        triangle.add(Arrays.asList(1,5,2,3,4));

        StdOut.println(minimumPathTotal(triangle));
    }

}
