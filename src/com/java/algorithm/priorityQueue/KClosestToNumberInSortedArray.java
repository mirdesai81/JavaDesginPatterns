package com.java.algorithm.priorityQueue;

import java.util.LinkedList;
import java.util.List;

public class KClosestToNumberInSortedArray {


        public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
            List<Integer> result = new LinkedList<>();
            int index = binarySearch(arr,X);
            int left = index;
            int right = index + 1;

            for(int i = 0; i < K; i++) {
                if(left >= 0 && right <= arr.length - 1) {
                    int diff1 = Math.abs(X - arr[left]);
                    int diff2 = Math.abs(X - arr[right]);

                    if(diff1 <= diff2) {
                        result.add(0,arr[left--]);
                    } else {
                        result.add(arr[right++]);
                    }
                } else if(left >= 0) {
                    result.add(0,arr[left--]);
                } else {
                    result.add(arr[right++]);
                }
            }
            // TODO: Write your code here
            return result;
        }

        public static int binarySearch(int[] arr,int X) {
            int start = 0;
            int end = arr.length - 1;

            while(start <= end) {
                int mid = start + (end - start) / 2;

                if(arr[mid] == X) return mid;

                if(X < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if(start > 0) {
                return start - 1;
            }

            return start;
        }

        public static void main(String[] args) {
            List<Integer> result = findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
            System.out.println("'K' closest numbers to 'X' are: " + result);

            result = findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
            System.out.println("'K' closest numbers to 'X' are: " + result);

            result = findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
            System.out.println("'K' closest numbers to 'X' are: " + result);
        }


}
