package com.java.algorithm.array;

/**
 * Created by mihir.desai on 4/12/2018.
 */
public class MoveZeroes {
    public static void moveZeroes(int[] a) {
        int low = 0;
        int high = a.length - 1;
        while(low < high) {
            if(a[low] != 0) {
                low++;
                continue;
            }

            if(a[high] == 0) {
                high--;
                continue;
            }

            swap(a,low,high);
            low++;
            high--;
        }

        print(a);
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

    public static void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1,0,3,0,0,4,0,10,0,9,0};
        moveZeroes(A);
    }
}
