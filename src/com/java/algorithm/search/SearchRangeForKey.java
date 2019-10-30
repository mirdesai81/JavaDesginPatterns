package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRangeForKey {
    public static List<Integer> findRangeOfK(List<Integer> A,int key) {
        int low = 0;
        int high = A.size() - 1;
        int lowRange = -1;
        int highRange = -1;
        List<Integer> result = new ArrayList<>();

        while(low <= high) {
            int mid = low + ((high-low)/2);
            if(A.get(mid) < key) {
                low = mid + 1;
            } else if(A.get(mid) == key) {
                lowRange = mid;
                high = mid - 1;
            } else {
                high = mid - 1;
            }
        }
        result.add(lowRange);

        if(lowRange == -1) {
            result.add(highRange);
            return result;
        }

        high = A.size() - 1;
        low = lowRange + 1;
        while(low <= high) {
            int mid = low + ((high-low)/2);
            if(A.get(mid) == key) {
                highRange = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        result.add(highRange);


        return result;
    }



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,4,4,4,6));
        StdOut.println("Range of 4 is at indexes - "+findRangeOfK(list,4));
    }
}
