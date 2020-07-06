package com.java.algorithm.search;

public class SearchKeyInRange {



        public static int[] findRange(int[] arr, int key) {
            int[] result = new int[] { -1, -1 };
            // TODO: Write your code here
            result[0] = search(arr,0,arr.length - 1,key,false);

            if(result[0] != -1) {
                result[1] = search(arr,result[0],arr.length - 1, key, true);
            }

            return result;
        }

        // modified Binary Search
        private static int search(int[] arr,int start,int end, int key, boolean findMaxIndex) {
            int keyIndex = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (key < arr[mid]) {
                    end = mid - 1;
                } else if (key > arr[mid]) {
                    start = mid + 1;
                } else { // key == arr[mid]
                    keyIndex = mid;
                    if (findMaxIndex)
                        start = mid + 1; // search ahead to find the last index of 'key'
                    else
                        end = mid - 1; // search behind to find the first index of 'key'
                }
            }
            return keyIndex;
        }

        public static void main(String[] args) {
            int[] result = findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
            System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
            result = findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
            System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
            result = findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
            System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        }

}
