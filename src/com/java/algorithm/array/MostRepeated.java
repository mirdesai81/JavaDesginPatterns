package com.java.algorithm.array;

/**
 * Created by mihir.desai on 4/12/2018.
 */
public class MostRepeated {

    public static int findMostRepeated(int a[],int k){
        int n = a.length;
        for(int i = 0; i < n; ++i){
            int index = a[i] % k;

            a[index] += k;
            System.out.println("index = "+index+" ,a[index] = "+a[index]);
        }
        print(a);
        int max = Integer.MIN_VALUE;
        int mostRepeated = -1;

        for(int i = 0; i < n; ++i) {
            if(a[i] > max) {
                max = a[i];
                mostRepeated = i;
                System.out.println("max = "+max+" ,repeated = "+i);
            }

            a[i] = a[i] % k;
        }

        return mostRepeated;
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

    public static void main(String[] args) {
        int[] a = {2, 4, 0, 5, 2, 1, 9, 9, 8, 4, 9, 7};
        int k = 10; /*The value of all numbers in the array are less than k and k <= n*/

        System.out.print("Input : ");
        print(a);

        int result = findMostRepeated(a, k);

        System.out.println("Most repeated element = " + result);
    }
}
