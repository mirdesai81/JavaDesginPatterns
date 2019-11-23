package com.java.algorithm.invariants;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxTrappedWater {

    public static int getMaxTrappedWater(List<Integer> heights) {
        int i = 0, j = heights.size() - 1,maxWater = 0;
        while(i < j) {
            int width = j - 1;
            maxWater = Math.max(maxWater, width * Math.min(heights.get(i),heights.get(j)));
            if(heights.get(i) < heights.get(j)) {
                ++i;
            } else if(heights.get(j) < heights.get(i)) {
                --j;
            } else {
                ++i;
                --j;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        List<Integer> hieghts = new ArrayList<>(Arrays.asList(1,2,1,3,4,4,5,6,2,1,3,1,3,2,1,2,4,1));
        StdOut.println(getMaxTrappedWater(hieghts));
    }
}
