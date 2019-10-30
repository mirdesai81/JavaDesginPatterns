package com.java.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingInArithmeticProgression {

    public static int findMissing(List<Integer> A) {
        int low = 0;
        int high = A.size() - 1;
        int diff = (A.get(high) - A.get(low))/A.size();
        int mid = -1;
        while(low <= high) {
            mid = low + (high - low)/2;
            // check A(mid) with next A(mid + 1) and not equal means next of mid is missing and one can get it by adding difference to mid
            if(A.get(mid + 1) - A.get(mid) != diff) {
                return A.get(mid) + diff;
            }

            if(mid > 0 && ((A.get(mid) - A.get(mid - 1)) != diff)) {
                return A.get(mid - 1) + diff;
            }

            // if middle element == n/2 term in arithmetic progress then missing lies in right half
            if(A.get(mid) == A.get(0) + (mid * diff)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1,4,7,10,13,16,19,25));
        System.out.println(findMissing(A));

         A = new ArrayList<>(Arrays.asList(1,4,10,13,16,19,22,25));
        System.out.println(findMissing(A));
    }
}
