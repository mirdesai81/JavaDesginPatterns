package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFirstOccurrence {

    public static int searchFirstOfK(List<Integer> list,Integer key) {
        int low = 0;
        int high = list.size() - 1;
        int result = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(list.get(mid) < key) {
                low = mid + 1;
            } else if(list.get(mid) == key) {
                result = mid;
                high = mid - 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static int searchFirstGreaterThanK(List<Integer> list,Integer key) {
        int low = 0;
        int high = list.size() - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            int num = list.get(mid);
            if (num < key) {
                low = mid + 1;
            } else if(num == key) {
                mid = mid + 1;
                while(mid <= high) {

                    if(list.get(mid).equals(key)) {
                        mid++;
                    } else {
                        return mid;
                    }
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,4,4,5,6));
        StdOut.println("First occurrence of 4 is at index - "+searchFirstOfK(list,4));

        StdOut.println("First occurrence of 4 is at index - "+searchFirstGreaterThanK(list,4));

    }
}
