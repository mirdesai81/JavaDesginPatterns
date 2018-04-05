package com.java.algorithm.sort;

import java.util.Arrays;

/**
 * Created by Mihir.Desai on 4/6/2017.
 */
public class MergeSort implements Sort {
    private static final int CUTOFF = 7;

    @Override
    public void sort(Comparable[] a) {
        Comparable[] src = a.clone();
        mergeSort(src,a,0,a.length -1);
    }

    private void mergeSort(Comparable[] src,Comparable[] dst, int low, int high) {
        if(high <= low + CUTOFF) {
            insertionSort(dst,low,high);
            return;
        }
        int mid = low + (high - low)/2;
        mergeSort(dst,src,low,mid);
        mergeSort(dst,src,mid + 1,high);

        if (!SortUtil.less(src[mid+1], src[mid])) {
            System.arraycopy(src, low, dst, low, high - low + 1);
            return;
        }

        merge(src,dst,low,mid,high);

    }

    private void merge(Comparable[] src,Comparable[] dst,int low, int mid, int high) {
        int i = low, j = mid + 1;

        for(int k = low; k <= high;k++) {
            if(i > mid) {
                dst[k] = src[j++];
            } else if( j > high) {
                dst[k] = src[i++];
            } else if(SortUtil.less(src[j],src[i])) {
                dst[k] = src[j++];
            } else {
                dst[k] = src[i++];
            }
        }

        /*Comparable[] temp = Arrays.copyOfRange(dst,low,high+1);
        SortUtil.show("After merge ",temp);*/
    }

    private void merge1(Comparable[] a,int low, int mid, int high) {
       /* int i = low, j = mid + 1;*/
        int n1 = mid - low + 1;
        int n2 = high - mid;

        Comparable[] L = new Comparable[n1];
        Comparable[] R = new Comparable[n2];
        //left subarray
        // start copying from low to mid
        for(int i = 0 ; i < n1; i++) L[i] = a[low + i];
        //right subarray
        // start copying from mid + 1 to high
        for(int j = 0 ; j < n2; j++) R[j] = a[mid + 1 + j];

        int i = 0, j = 0;
        int k = low;
        while( i < n1 && j < n2) {
            if(SortUtil.less(L[i] ,R[j])) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from L and R subarray if remaining
        while(i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while(j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }


    }

    private void insertionSort(Comparable[] a,int low,int high) {
        /*System.out.println("Insertion called for small arrays");*/
        for(int i = low; i <= high; i++) {
            for(int j = i; j > low && SortUtil.less(a[j],a[j-1]);j-- ) {
                SortUtil.exchange(a,j,j-1);
            }
        }

        /*Comparable[] temp = Arrays.copyOfRange(a,low,high+1);
        SortUtil.show("Insertion Sort ",temp);*/
    }
}
