package com.java.algorithm.educative.hashtable;

import java.util.HashMap;

public class FindSymetricPairArray {

    public static String findSymmetric(int[][] arr) {

        String result = "";
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            Integer val = map.get(y);
            if(val != null && val == x) {
                result += "{" + y + "," + x + "}";
            }
            map.put(x,y);

        }

        // Write - Your - Code
        return result;
    }

    public static void main(String args[]) {

        int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        String symmetric = findSymmetric(arr);
        System.out.println(symmetric);

    }
}
