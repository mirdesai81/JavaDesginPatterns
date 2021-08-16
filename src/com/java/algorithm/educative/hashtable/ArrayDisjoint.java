package com.java.algorithm.educative.hashtable;

import java.util.HashSet;

public class ArrayDisjoint {

    public static Object isDisjoint(int[] arr1,int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length;i++) {
            if(set.contains(arr2[i])) return false;
        }

        // Write - Your - Code
        return true;
    }

    public static void main(String args[]) {

        int[] arr1 = {9, 4, 3, 1, -2, 6, 5};
        int[] arr2 = {7, 10, 8};
        int[] arr3 = {1, 12};
        System.out.println(isDisjoint(arr1, arr2));
        System.out.println(isDisjoint(arr1, arr3));

    }
}
