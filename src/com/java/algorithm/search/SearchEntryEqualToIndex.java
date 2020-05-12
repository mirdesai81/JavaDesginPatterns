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

    public static int searchMagicNumber(List<Integer> list) {
        return searchMagicNumber(list,0,list.size() - 1);
    }

    private static int searchMagicNumber(List<Integer> list,int start,int end) {
        if(end < start) return -1;

        int midIndex = start + ((end - start) / 2);
        int midValue = list.get(midIndex);

        if(midIndex == midValue) return midIndex;

        int leftIndex = Math.min(midIndex - 1,midValue);
        int left = searchMagicNumber(list,start,leftIndex);
        if(left >= 0) return left;

        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = searchMagicNumber(list,rightIndex,end);

        return right;
    }

    public static void main(String[] args) {

        /*
            0      1  2  3  4 5 6 7 8 9 10
            -40 ,-20, 2, 2, 3 4 5 7
         */

        List<Integer> list = new ArrayList<>(Arrays.asList(-40 ,-20, 2, 2, 3, 4, 5, 7,7,9,10));
        StdOut.println(searchEntryEqualToIndex(list));

        StdOut.println(searchMagicNumber(list));
    }
}
