package com.java.algorithm.priorityQueue;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedIncreasingDecreasingArray {

    private static enum SubarrayType { INCREASING, DECREASING};

    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
        List<List<Integer>> sortedSubArrays = new ArrayList<>();
        int startIdx = 0;
        SubarrayType subarrayType = SubarrayType.INCREASING;
        for(int i = 1 ; i <= A.size(); i++) {

            if((i == A.size()) ||
                    (A.get(i - 1) < A.get(i) && subarrayType == SubarrayType.DECREASING) ||
                    (A.get(i - 1) >= A.get(i) && subarrayType == SubarrayType.INCREASING)
                    ) {
                List<Integer> subList = A.subList(startIdx,i);
                if(subarrayType == SubarrayType.DECREASING) {
                    Collections.reverse(subList);
                }
                sortedSubArrays.add(subList);
                startIdx = i;
                subarrayType = (subarrayType == SubarrayType.INCREASING ? SubarrayType.DECREASING : SubarrayType.INCREASING);
            }

        }

        return MergeSortedArrays.mergeSortedArrays(sortedSubArrays);

    }

    public static void main(String[] args) {

        List<Integer> arrays = new ArrayList<>();
        arrays.add(57);
        arrays.add(131);
        arrays.add(493);
        arrays.add(294);
        arrays.add(221);
        arrays.add(339);
        arrays.add(418);
        arrays.add(452);
        arrays.add(442);
        arrays.add(190);

        StdOut.println(sortKIncreasingDecreasingArray(arrays));
    }
}
