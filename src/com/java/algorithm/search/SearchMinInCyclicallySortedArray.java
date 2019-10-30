package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchMinInCyclicallySortedArray {

    public static int searchMin(List<Integer> A) {
        int low = 0;
        int high = A.size() - 1;

        while(low < high) {
            int mid = low + (high - low)/2;
            if(A.get(mid) > A.get(high)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static int searchMax(List<Integer> A) {
        int low = 0;
        int high = A.size() - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(A.get(mid) > A.get(mid + 1) && A.get(mid) > A.get(mid - 1)) {
                return mid;
            } else if(A.get(mid) > A.get(mid + 1) && A.get(mid) < A.get(mid - 1)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    public static int findK(List<Integer> A, int k) {
        int left = 0;
        int right = A.size() - 1;

        while(left <= right) {
            int mid = left + ((right - left) / 2);
            Integer value = A.get(mid);
            if(value == k) {
                return mid;
            } else if(A.get(left) <= A.get(mid) ) {
                if(k <= A.get(mid) && k >= A.get(left)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(k >= A.get(mid) && k <= A.get(right)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(378, 478, 550, 631, 103, 200, 220, 350));
        StdOut.println(searchMin(list));
        StdOut.println(findK(list,103));

        list = new ArrayList<>(Arrays.asList(378, 478, 550, 631,714,800, 350, 280, 220, 110));
        StdOut.println(searchMax(list));
    }
}
