package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFirstOccurrence {

    public static int searchFirstOfK(List<Integer> list,Integer key) {
        int result = -1;
        int left = 0;
        int right = list.size() - 1;

        while(left <= right) {
            int mid = left + ((right - left) / 2);

            if(list.get(mid) > key) {
              right = mid - 1;
            } else if(list.get(mid) == key) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,4,4,5,6));
        StdOut.println("First occurrence of 4 is at index - "+searchFirstOfK(list,4));
    }
}
