package com.java.algorithm.educative.heap;

import java.util.Arrays;

public class FindKLargest {

    public static int[] findKLargest(int[] arr,int k) {

        int[] result = new int[k];

        int heapSize = arr.length;

        if(k <= heapSize) {
            for(int i = 0; i < k; i++) {
                result[i] = removeMaxFromHeap(arr,heapSize);
                --heapSize;
            }
        }

        // Write - Your - Code
        return result;
    }

    public static int removeMaxFromHeap(int[] arr,int heapSize) {
        buildMaxHeap(arr,heapSize);
        int min = arr[0];
        arr[0] = arr[heapSize - 1];
        return min;
    }

    public static void buildMaxHeap(int[] arr,int heapSize) {
        for(int i = (heapSize - 1)/2; i >= 0; i--) {
            buildMaxHeap(arr,i,heapSize);
        }
    }

    public static void buildMaxHeap(int[] arr,int index,int heapSize) {
        int largest = index;

        while(largest < heapSize/2) {
            int left = 2*index + 1;
            int right = 2*index + 2;
            if(left < heapSize && arr[left] > arr[index]) {
                largest = left;
            }

            if(right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }

            if(largest != index) {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                index = largest;
            } else {
                break;
            }
        }
    }

    public static void main(String args[]) {
        int[] heapArray = {9,4,7,1,-2,6,5};
        System.out.println("Max Heap: " + Arrays.toString(heapArray));
        int[] result = findKLargest(heapArray,4);
        System.out.println("K = 3 smallest in array: " + Arrays.toString(result));

    }
}
