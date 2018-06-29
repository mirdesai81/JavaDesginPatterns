package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchMaxInAscDescArray {

    public static int searchMaxAscDesc(List<Integer> A) {
        int left = 0;
        int right = A.size() - 1;
        while(left <= right) {
            int mid = left + ((right - left) / 2);
            if(A.get(mid) > A.get(mid - 1) && A.get(mid) > A.get(mid + 1)) {
                StdOut.println(A.get(mid));
                return mid;
            } else if(A.get(mid) > A.get(mid - 1) && A.get(mid) < A.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(8,10,20,80,100,200,500,400, 350, 250, 30));
        StdOut.println(searchMaxAscDesc(list));

    }
}
