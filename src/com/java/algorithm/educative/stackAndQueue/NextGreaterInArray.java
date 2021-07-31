package com.java.algorithm.educative.stackAndQueue;

import java.util.Arrays;

public class NextGreaterInArray {

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>(arr.length);
        // Write -- Your -- Code
        for(int i = arr.length - 1; i >= 0; i--) {
            Integer value = arr[i];

            while(!stack.isEmpty() && value > stack.top()) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                result[i] = stack.top();
            } else {
                result[i] = -1;
            }

            stack.push(value);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int arr[] = {4,6,3,2,8,1,11};
        System.out.println(Arrays.toString(arr));
        int result[] = nextGreaterElement(arr);
        System.out.println(Arrays.toString(result));
    }
}
