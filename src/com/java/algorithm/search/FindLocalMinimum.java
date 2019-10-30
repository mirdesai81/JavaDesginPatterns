package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLocalMinimum {

    public static int findLocalMinimum(List<Integer> A) {
        int low = 0;
        int high = A.size() - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            // first and last element and middle element
            if((mid == 0 || A.get(mid - 1) > A.get(mid)) &&
                    (mid == A.size() - 1 || A.get(mid + 1) > A.get(mid))) {
                return mid;
            } else if(mid > 0 && A.get(mid - 1) < A.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(11,4,2,5,11,13,5));
        StdOut.println("Local Minimum - "+findLocalMinimum(list));



    }
}
