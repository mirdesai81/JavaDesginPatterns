package com.java.algorithm.educative.array;

import java.util.HashMap;
import java.util.Map;

class CheckSum
{
    public static int[] findSum(int[] arr, int n)
    {
        Map<Integer,Integer> lookup = new HashMap<>();
        int[] result = new int[2];
        // write your code here
        for(int i = 0; i < arr.length; i++) {
            int diff = n - arr[i];

            if(lookup.containsKey(diff)) {
                result[0] = diff;
                result[1] = arr[i];
                return result;
            }

            lookup.put(arr[i],i);
        }

        return result;   // return the elements in the array whose sum is equal to the value passed as parameter
    }
}
