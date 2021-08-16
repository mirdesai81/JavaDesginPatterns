package com.java.algorithm.educative.hashtable;

import java.util.HashSet;

public class ArraySubset {

    public static boolean isSubset(int[] arr1, int[] arr2) {
        // write your code here
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++) {
            if(!set.contains(arr2[i])){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {

        int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
        int[] arr2 = {7, 1, -2};
        int[] arr3 = {10, 12};

        System.out.println(isSubset(arr1, arr2));
        System.out.println(isSubset(arr1, arr3));
    }
}
