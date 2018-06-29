package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchMinInCyclicallySortedArray {

    public static int searchMin(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while(left < right) {
            int mid = left + ((right - left) / 2);
            if(list.get(mid) > list.get(right)) {
                // sublist mid + 1 to right + 1
                left = mid + 1;
            } else {
                // sublist left , mid + 1
                right = mid;
            }
        }

        return left;
    }


    public static int findK(List<Integer> A, int k) {
        int left = 0;
        int right = A.size() - 1;

        while(left <= right) {
            int mid = left + ((right - left) / 2);
            StdOut.println(A.get(mid));
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
        //StdOut.println(searchMin(list));
        StdOut.println(findK(list,103));
    }
}
