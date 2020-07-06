package com.java.algorithm.search;

public class FindKTimesArrayRotated {



        public static int countRotations(int[] arr) {
            // TODO: Write your code here

            int start = 0;
            int end = arr.length - 1;
            if(arr[end] > arr[start]) {
                return 0;
            }

            while(start <= end) {

                int mid = start + (end - start)/2;
                if(mid < end && arr[mid] > arr[mid + 1]) {
                    return mid + 1;
                } else if(mid > start && arr[mid - 1] > arr[mid]) {
                    return mid;
                }

                if(arr[mid] >= arr[start] && arr[mid] < arr[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }


            }

            return -1;
        }

        public static void main(String[] args) {
            System.out.println(countRotations(new int[] { 10, 15, 1, 3, 8 }));
            System.out.println(countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
            System.out.println(countRotations(new int[] { 1, 3, 8, 10 }));
            System.out.println(countRotations(new int[] { 10,1, 3, 8 }));
            System.out.println(countRotations(new int[] { 10,1, 3, 8, 10, 10 }));
        }


}
