package com.java.algorithm.educative.array;

import java.util.Arrays;
import java.util.List;

public class SearchLowHighIndex {


        static int findLowIndex(List<Integer> arr, int key) {
            int start = 0;
            int end = arr.size() - 1;

            if(arr.get(0) == key)
                return 0;

            while(start <= end) {
                int mid = start + (end - start)/ 2;
                if(arr.get(mid) >= key) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }


            return start < arr.size() && arr.get(start) == key ? start : -1;
        }

        static int findHighIndex(List<Integer> arr, int key) {
            //TODO: Write - Your - Code
            int start = 0;
            int end = arr.size() - 1;

            if(arr.get(end) == key)
                return end;

            while(start <= end) {
                int mid = start + (end - start)/ 2;
                if(arr.get(mid) <= key) {
                    start = mid + 1;
                } else  {
                    end = mid - 1;
                }
            }

            if(end == -1) {
                return end;
            }

            return end < arr.size() && arr.get(end) == key ? end : -1;
        }

        public static void main(String[] args) {
            List<Integer> search = Arrays.asList(1,1,2,2,2,2,2,2,2,3,3,4);
            int low = findLowIndex(search,2);
            int high = findHighIndex(search,2);
            System.out.println("low = "+low+" , high = "+high);
        }

}
