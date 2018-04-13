package com.java.algorithm.array;

import java.util.Arrays;

/**
 * Created by mihir.desai on 4/12/2018.
 */
public class ThreeElementSum {

    public static int find3ElementSum(int a[],int s) {
        if(a.length < 3) {
            return -1;
        }
        int n = a.length;
        Arrays.sort(a);
        int count = 0;
        for(int i = 0; i < n - 2;++i) {
            int low = i + 1;
            int high = n - 1;
            while(low < high) {
                int total = a[i] + a[low] + a[high];
                System.out.println("i = "+ i + " ,low =  " + low +
                        ",high = " + high + " ,total = " + total);
                if(total == s) {
                    count++;
                    System.out.println(a[i] + " + " + a[low] +
                            " + " + a[high] + " = " + total);
                    ++low;
                    high--;
                } else if(total > s) {
                    high--; //
                } else {
                    low++; // for less we need to pick a larger element
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1 , 12, -5, 6, 7};
        System.out.println(find3ElementSum(A,8));
    }
}
