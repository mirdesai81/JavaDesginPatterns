package com.java.algorithm.sort;

import com.java.algorithm.array.ArrayUtils;

public class MergeSortSolution {

    static void merge(int array[], int p, int q, int r) {
        // This code has been purposefully obfuscated,
        //  as you'll write it yourself in next challenge.
        int i, j, k;
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0; i < n1; i++) L[i] = array[p + i];
        for (j = 0; j < n2; j++) R[j] = array[q + 1 + j];
        i = 0;
        j = 0;
        k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Takes in an array and recursively merge sorts it
    public static void mergeSort(int[] array, int p, int r) {

        // Write this method
        if (p < r) {
            int q = (p + r)/ 2;

            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);

            merge(array, p, q, r);
        }
    }

    public static void main(String[] args) {
        int[] array = {4,3,2,1};
        mergeSort(array,0,3);
        ArrayUtils.print("Merge", array);
    }
}
