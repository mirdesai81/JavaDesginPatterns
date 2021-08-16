package com.java.algorithm.educative.hashtable;

import java.util.HashMap;

public class FindPairSumEqualToTarget {

    public static int[] findSum(int[] arr, int n)
    {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {

            if(map.containsKey(arr[i])) {
                result[0] = map.get(arr[i]);
                result[1] = arr[i];
                return result;
            }

            map.put(n - arr[i],arr[i]);
        }

        // write your code here
        return result;   // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static void main(String args[])
    {
        int n = 0;
        int[] arr1 = {};
        if(arr1.length > 0){
            int[] arr2 = findSum(arr1, n);
            int num1 = arr2[0];
            int num2 = arr2[1];

            if((num1 + num2) != n)
                System.out.println("Not Found");
            else {
                System.out.println("Number 1 = " + num1);
                System.out.println("Number 2 = " + num2);
                System.out.println("Sum = " +  (n) );

            }
        } else {
            System.out.println("Input Array is Empty!");
        }
    }
}
