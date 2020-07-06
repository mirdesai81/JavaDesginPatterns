package com.java.algorithm.search;

public class FindKeyInDescendingAscending {


        public static int search(int[] arr, int key) {
            // TODO: Write your code here
            int start = 0;
            int end = arr.length - 1;
            int index = -1;
            while(start < end) {
                int mid = start + (end - start)/2;

                if(arr[mid] > arr[mid + 1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }

            }

            if(arr[start] == key) {
                return start;
            }

            // do search in left
            index = search(arr,key,0,end);

            // do search in right
            if(index == -1) {
                index = search(arr,key,start,arr.length - 1);
            }

            return index;
        }

        public static int search(int[] arr,int key,int start,int end) {
            while(start <= end) {
                int mid = start + (end - start)/2;
                if(key < arr[mid]) {
                    end = mid - 1;
                } else if(key > arr[mid]) {
                    start = end + 1;
                } else {
                    return mid;
                }
            }

            return -1;
        }

        public static void main(String[] args) {
            System.out.println(search(new int[] { 1, 3, 8, 4, 3 }, 4));
            System.out.println(search(new int[] { 3, 8, 3, 1 }, 8));
            System.out.println(search(new int[] { 1, 3, 8, 12 }, 12));
            System.out.println(search(new int[] { 10, 9, 8 }, 10));
        }

}
