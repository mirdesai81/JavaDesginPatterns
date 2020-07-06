package com.java.algorithm.search;

public class SearchInRotatedArray {


        public static int search(int[] arr, int key) {
            // TODO: Write your code here
            int start = 0;
            int end = arr.length - 1;

            while(start <= end) {
                int mid = start + (end - start) / 2;
                if(arr[mid] == key) {
                    if(arr[mid] == arr[mid - 1]) {
                        end = mid - 1;
                        continue;
                    } else {
                        return mid;
                    }


                }
                // handle duplicates
                if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
                    start++;
                    end--;
                }
                // right of middle is sorted
                else if(arr[mid] < arr[start]) {
                    // key in range from mid + 1 to end
                    if(key > arr[mid] && key <= arr[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else { // check left of mid

                    // key in range from start to mid - 1
                    if(key >= arr[start] && key < arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }

            return -1;
        }

        public static void main(String[] args) {
           // System.out.println(search(new int[] { 10, 15, 1, 3, 8 }, 15));
           // System.out.println(search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
            System.out.println(search(new int[] { 3, 3, 3, 3, 7,7, 7,3 }, 7));
        }


}
