package com.java.algorithm.invariants;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeElementSum {

    public static boolean hasTwoSum(List<Integer> A, int t, int i, int j) {
        int currentIndex = i - 1;
        while(i < j) {
            if(A.get(i) + A.get(j) == t) {
                StdOut.println(String.format("A[%d] , A[%d], A[%d]",currentIndex,i,j));
                return true;
            } else if(A.get(i) + A.get(j) < t) {
                ++i;
            } else {
                --j;
            }
        }

        return false;
    }

    public static boolean hasThreeElementSum(List<Integer> A, int t) {
        //Collections.sort(A);

        for(int i = 0; i < A.size() - 1; i++) {
            if(hasTwoSum(A,t - A.get(i), i + 1,A.size() - 1)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(5,2,3,4,3));
        StdOut.println(hasThreeElementSum(A,9));
    }
}
