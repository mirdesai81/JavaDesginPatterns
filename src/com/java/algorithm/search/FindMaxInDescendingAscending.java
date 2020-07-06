package com.java.algorithm.search;

public class FindMaxInDescendingAscending {

        public static int findMax(int[] arr) {
            // TODO: Write your code here
            int start = 0;
            int end = arr.length - 1;

            while(start < end) {
                int mid = start + (end - start)/2;
                if(arr[mid] > arr[mid + 1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            return arr[end];
        }

        public static void main(String[] args) {
            System.out.println(findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
            System.out.println(findMax(new int[] { 3, 8, 3, 1 }));
            System.out.println(findMax(new int[] { 1, 3, 8, 12 }));
            System.out.println(findMax(new int[] { 10, 9, 8 }));
        }

}
