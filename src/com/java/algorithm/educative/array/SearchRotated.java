package com.java.algorithm.educative.array;

class SearchRotated{
    static int binarySearchRotated(int[] arr,int key) {
        //TODO: Write - Your - Code
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end-start)/2 ;

            if(arr[mid] == key) return mid;

            // arr[mid ... end] is sorted
            if(arr[mid] <= arr[end]) {
                if(key > arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else {
                if(key >= arr[start] & key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 220, 250, 290, 400, 10, 25, 100, 120, 150, 175, 180, 210, 215, 219};
        System.out.println(binarySearchRotated(arr, 250));
    }
}
