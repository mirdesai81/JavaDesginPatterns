package com.java.algorithm.educative.heap;

import java.util.Arrays;

public class FindKSmallest {

    public static int[] findKSmallest(int[] arr,int k) {

        int[] result = new int[k];

        int heapSize = arr.length;

        if(k <= heapSize) {
            for(int i = 0; i < k; i++) {
                result[i] = removeMinFromHeap(arr,heapSize);
                --heapSize;
            }
        }

        // Write - Your - Code
        return result;
    }

    public static int removeMinFromHeap(int[] arr,int heapSize) {
        buildMinHeap(arr,heapSize);
        int min = arr[0];
        arr[0] = arr[heapSize - 1];
        return min;
    }

    public static void buildMinHeap(int[] arr,int heapSize) {
        for(int i = (heapSize - 1)/2; i >= 0; i--) {
            buildMinHeap(arr,i,heapSize);
        }
    }

    public static void buildMinHeap(int[] arr,int index,int heapSize) {
        int smallest = index;

        while(smallest < heapSize/2) {
            int left = 2*index + 1;
            int right = 2*index + 2;
            if(left < heapSize && arr[left] < arr[smallest]) {
                smallest = left;
            }

            if(right < heapSize && arr[right] < arr[smallest]) {
                smallest = right;
            }

            if(smallest != index) {
                int temp = arr[index];
                arr[index] = arr[smallest];
                arr[smallest] = temp;
                index = smallest;
            } else {
                break;
            }
        }
    }

    public static void main(String args[]) {
        int[] heapArray = {9,4,7,1,-2,6,5};
        System.out.println("Max Heap: " + Arrays.toString(heapArray));
        int[] result = findKSmallest(heapArray,3);
        System.out.println("K = 3 smallest in array: " + Arrays.toString(result));

    }
}
