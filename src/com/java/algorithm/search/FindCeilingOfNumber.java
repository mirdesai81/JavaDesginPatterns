package com.java.algorithm.search;

public class FindCeilingOfNumber {


        public static int searchCeilingOfANumber(int[] arr, int key) {
            // TODO: Write your code here
            if(key > arr[arr.length - 1]) {
                return -1;
            }

            int start = 0;
            int end = arr.length - 1;
            int mid = -1;

            while(start <= end) {
                mid = start + (end - start)/2;
                if(key > arr[mid]) {
                    start = mid + 1;
                } else if(key < arr[mid]) {

                    end = mid - 1;
                } else {
                    return mid;
                }
            }

            return start;
        }

        public static void main(String[] args) {
            System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
            System.out.println(searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
            System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
            System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
        }

}
