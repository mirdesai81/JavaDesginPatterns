package com.java.algorithm.educative.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindFirstUniqueInArray {

    public static int findFirstUnique(int[] arr) {

        Map<Integer, Integer> countElements = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countElements.put(arr[i], 0);
        }

        for (int i = 0; i < arr.length; i++) {
            countElements.put(arr[i], countElements.get(arr[i]) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (countElements.get(arr[i]) <= 1) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String args[]) {

        int[] arr = {2, 54, 7, 2, 6, 54};

        System.out.println("Array: " + Arrays.toString(arr));

        int unique = findFirstUnique(arr);
        System.out.print("First Unique in an Array: " + unique);

    }
}
