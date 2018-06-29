package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchEntryEqualToIndex {

    public static int searchEntryEqualToIndex(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while(left <= right) {
            int mid = left + ((right - left) / 2);
            int difference = list.get(mid) - mid;
            if(difference == 0) {
                return mid;
            } else if(difference > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-2, 0,2,3,6,7,9));
        StdOut.println(searchEntryEqualToIndex(list));
    }
}
