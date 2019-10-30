package com.java.algorithm.array;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonTwoSortedArrays {

    public static List<Integer> intersectTwoSortedArrays(List<Integer> A , List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while(i < A.size() && j < B.size()) {
            if(A.get(i) == B.get(j) && ( i == 0 || A.get(i) != A.get(i - 1))) {
                result.add(A.get(i));
                ++i;
                ++j;
            } else if(A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(2,2,5,5,7,18));
        List<Integer> B = new ArrayList<>(Arrays.asList(2,3,5,5,10,17,18));
        StdOut.println(intersectTwoSortedArrays(A,B));
    }
}
