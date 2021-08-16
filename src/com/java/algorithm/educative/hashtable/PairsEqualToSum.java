package com.java.algorithm.educative.hashtable;

import java.util.HashMap;

public class PairsEqualToSum {


    public static String findPair(int[] arr) {

        String result = "";
        HashMap<Integer,Integer[]> map = new HashMap<>();
        Integer[] pair = new Integer[2];
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length;j++) {
                int sum = arr[i] + arr[j];

                if(map.containsKey(sum)) {
                    pair = map.get(sum);
                    return "{" + pair[0] + "," + pair[1] + "}" + "{" + arr[i] + "," + arr[j] + "}";

                } else {
                    pair[0] = arr[i];
                    pair[1] = arr[j];
                    map.put(sum,new Integer[] {arr[i] , arr[j]});
                }
            }
        }

        // Write - Your - Code
        return null;
    }

    public static void main(String args[]) {

        int[] arr = {3, 4, 7, 1, 12, 9};
        System.out.println(findPair(arr));

    }
}
