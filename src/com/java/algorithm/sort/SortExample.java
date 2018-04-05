package com.java.algorithm.sort;

import com.java.algorithm.TimingUtil;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Mihir.Desai on 3/30/2017.
 */
public class SortExample {


    public static void main(String[] args) {
        // Selection Sort
    /*    String[] data = new String[] {"S","O","R","T","E","A","M","P","L","E"};
        SortUtil.show("Before Selection Sort -> ",data);
        Sort selectionSort = new SelectionSort();
        TimingUtil.timed("Selection Sort",(Comparable[] t) -> selectionSort.sort(t),data);
        assert SortUtil.isSorted(data);
        SortUtil.show("Selection Sort -> ",data);


        //Insertion Sort
        String[] a = new String[] {"S","O","R","T","E","A","M","P","L","E"};
        SortUtil.show("Before Insertion Sort -> ",a);
        Sort insertionSort = new InsertionSort();
        TimingUtil.timed("Insertion Sort",(Comparable[] t) -> insertionSort.sort(t),a);
        assert SortUtil.isSorted(a);
        SortUtil.show("Insertion Sort -> ",a);*/

        int N = 1000;
        int T = 1;
        String alg1 = "Quick";
        String alg2 = "Merge";
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        System.out.printf("%s : %.1f msecs, %s : %.1f msecs%n",alg1,t1,alg2,t2);

        if(t2 > t1) {
            double time = 0.0;
            if(t1 > 0.0) {
                time = t2/t1;
            } else {
                time = t2;
            }

            System.out.printf("For %d random Doubles\n %s is", N, alg1);
            System.out.printf(" %.1f times faster than %s\n", time, alg2);
        } else {
            double time = 0.0;
            if(t2 > 0.0) {
                time = t1/t2;
            } else {
                time = t1;
            }

            System.out.printf("For %d random Doubles\n %s is", N, alg2);
            System.out.printf(" %.1f times faster than %s\n", time, alg1);
        }


    }

    public static double timeRandomInput(String algo,int N,int T) {
        double total = 0.0;

        Random r = new Random();
        for(int i = 0; i < T; i++) {
            /*Integer[] a = r.ints(N,1,1000000).boxed().toArray(size -> new Integer[size]);*/
            String[] a = new String[] {"S","O","R","T","E","A","M","P","L","E"};
            if(algo.equalsIgnoreCase("Insertion")) {
                SortUtil.show("Before Insertion Sort -> ",a);
                Sort insertionSort = new InsertionSort();
                total += TimingUtil.timed("Insertion Sort",(Comparable[] t) -> insertionSort.sort(t),a);
                SortUtil.show("Insertion Sort -> ",a);
            } else if(algo.equalsIgnoreCase("Selection")) {
                SortUtil.show("Before Selection Sort -> ",a);
                Sort selectionSort = new SelectionSort();
                total += TimingUtil.timed("Selection Sort",(Comparable[] t) -> selectionSort.sort(t),a);
                SortUtil.show("Selection Sort -> ",a);
            } else if(algo.equalsIgnoreCase("Shell")) {
                SortUtil.show("Before Shell Sort -> ",a);
                Sort shellSort = new ShellSort();
                total += TimingUtil.timed("Shell Sort",(Comparable[] t) -> shellSort.sort(t),a);
                SortUtil.show("Shell Sort -> ",a);
            } else if(algo.equalsIgnoreCase("Merge")) {
                SortUtil.show("Before Merge Sort -> ",a);
                Sort mergeSort = new MergeSort();
                total += TimingUtil.timed("Merge Sort",(Comparable[] t) -> mergeSort.sort(t),a);
                SortUtil.show("Merge Sort -> ",a);
            } else if(algo.equalsIgnoreCase("Quick")) {
                SortUtil.show("Before Quick Sort -> ",a);
                Sort quickSort = new QuickSort();
                total += TimingUtil.timed("Quick Sort",(Comparable[] t) -> quickSort.sort(t),a);
                SortUtil.show("Quick Sort -> ",a);
            }

        }

        return total;
    }
}
