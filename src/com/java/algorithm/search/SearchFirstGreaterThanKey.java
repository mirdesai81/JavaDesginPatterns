package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFirstGreaterThanKey {

    public static int searchFirstGreaterThanK(List<Integer> list, Integer key) {
        int result = -1;
        int left = 0;
        int right = list.size() - 1;
        int value = -1;

        while(left <= right) {
            int mid = left + ((right - left) / 2);

            if(list.get(mid) <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        StdOut.println("Value -"+list.get(right + 1));
        return right + 1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,4,5,5,6));
        StdOut.println("First occurrence of key greater than 4 is at index - "+searchFirstGreaterThanK(list,4));
    }
}
