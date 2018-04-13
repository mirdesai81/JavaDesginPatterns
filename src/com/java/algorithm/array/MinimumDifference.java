package com.java.algorithm.array;

import java.util.Arrays;

/**
 * Created by mihir.desai on 4/12/2018.
 */
public class MinimumDifference {
    public static int findMinDifference(int a[]) {
        Arrays.sort(a);
        print(a);
        int min = a[1] - a[0];

        for(int i = 1; i < a.length - 1; i++) {
            if(a[i + 1] - a[i] < min) {
                min = a[i + 1] - a[i];
                System.out.println(min);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] A = new int[] { 0, -2, -5, 1, 2, 4};
        System.out.println(findMinDifference(A));
    }

    private static void print(int a[]) {
        for(int i = 0; i < a.length;++i) {
            if(i == a.length - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + " --> ");
            }
        }

        System.out.println("");
    }
}
