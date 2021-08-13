package com.java.algorithm.educative.heap;

import java.util.Arrays;

public class ConvertMaxToMinHeap {

    public static void convertMax(int[] maxHeap) {

        //Consider maxHeap just an ordinary unsorted array
        //Build minHeap of the given array. (We already covered that in previous lesson)
        //Return converted array in String format
        buildMinHeap(maxHeap, maxHeap.length);

    }

    private static void buildMinHeap(int[] heapArray, int heapSize) {

        // swap smallest child to parent node
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            minHeapify(heapArray, i, heapSize);
        }
    }

    private static void minHeapify(int[] heapArray, int index, int heapSize) {
        int smallest = index;

        while (smallest < heapSize / 2) { // check parent nodes only
            int left = (2 * index) + 1; //left child
            int right = (2 * index) + 2; //right child
            if (left < heapSize && heapArray[left] < heapArray[index]) {
                smallest = left;
            }

            if (right < heapSize && heapArray[right] < heapArray[smallest]) {
                smallest = right;
            }

            if (smallest != index) { // swap parent with smallest child
                int temp = heapArray[index];
                heapArray[index] = heapArray[smallest];
                heapArray[smallest] = temp;
                index = smallest;
            } else {
                break; // if heap property is satisfied
            }
        } //end of while
    }


    public static void main(String args[]) {
        int[] heapArray = {9,4,7,1,-2,6,5};
        System.out.println("Max Heap: " + Arrays.toString(heapArray));
        convertMax(heapArray);
        System.out.println("Min Heap: " + Arrays.toString(heapArray));

    }
}
