package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRangeForKey {
    public static List<Integer> findRangeOfK(List<Integer> list,int key) {
        int left = 0;
        int right = list.size() - 1;
        int lowRange = -1;
        int highRange = -1;
        List<Integer> result = new ArrayList<>();
        while(left <= right) {
            int mid = left + ((right - left) / 2);
            if(list.get(mid) < key) {
                left = mid + 1;
            } else if(list.get(mid) == key) {
                lowRange = mid;
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        result.add(lowRange);
        right = list.size() - 1;

        while(lowRange <= right) {
            int mid = lowRange + ((right - lowRange) / 2);
            if(list.get(mid) < key) {
                lowRange = mid + 1;
            } else if(list.get(mid) == key) {
                highRange = mid;
                lowRange = mid + 1;
            } else {
                right = mid - 1;
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
