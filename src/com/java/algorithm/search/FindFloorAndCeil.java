package com.java.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFloorAndCeil {

    public static int findFloor(List<Integer> A, int x) {
        int low = 0;
        int high = A.size() - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(A.get(mid) == x || (A.get(mid) < x && (mid == high || A.get(mid + 1) > x))) {
                return mid;
            } else if(A.get(mid) > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int findCeil(List<Integer> A, int x) {
        int low = 0;
        int high = A.size() - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(A.get(mid) == x || (A.get(mid) > x && (mid == low || A.get(mid - 1) < x))) {
                return mid;
            } else if(A.get(mid) > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1,2,5,6,11,15));
        System.out.println("Floor of 16 "+findFloor(A,16));
        System.out.println("Floor of 3 "+findFloor(A,3));

        System.out.println("Ceil of 7 "+findCeil(A,7));
        System.out.println("Ceil of 3 "+findCeil(A,3));
    }
}
