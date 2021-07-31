package com.java.algorithm.educative.array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Returns first unique integer from array
class CheckFirstUnique {
    public static int findFirstUnique(int[] arr) {
        Map<Integer,Integer> unique = new LinkedHashMap<>();
        Map<Integer,Integer> dupMap = new HashMap<>();
        unique.put(arr[0],0);
        for(int i = 1; i < arr.length; i++) {

            if(unique.containsKey(arr[i]) || dupMap.containsKey(arr[i])){
                dupMap.put(arr[i],dupMap.getOrDefault(arr[i],0) + 1);
                unique.remove(arr[i]);
            } else {
                unique.put(arr[i],i);
            }


        }

        if(unique.isEmpty()) {
            return -1;
        }
        // write your code here
        return unique.keySet().iterator().next();

    }
    public static String arrayToString(int arr[]){
        if (arr.length > 0){
            String result = "";
            for(int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        }
        else {
            return "Empty Array!";
        }
    }

    public static void  main(String args[]) {

        int[] arr = {2, 54, 7, 2, 6, 54};

        System.out.println("Array: " + arrayToString(arr));

        int unique = findFirstUnique(arr);
        System.out.print("First Unique in an Array: " + unique);

    }
}