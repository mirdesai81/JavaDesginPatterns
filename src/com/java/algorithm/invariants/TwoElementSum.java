package com.java.algorithm.invariants;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoElementSum {
    public static boolean hasTwoSum(List<Integer> A,int t,int i, int j) {
        while(i <= j) {
            if(A.get(i) + A.get(j) == t) {
                return true;
            } else if(A.get(i) + A.get(j) < t) {
                ++i;
            } else {
                --j;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(-2,1,2,4,7,11));
        StdOut.println(hasTwoSum(A,6,0,A.size() - 1));
    }
}
