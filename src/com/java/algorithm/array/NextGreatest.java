package com.java.algorithm.array;

/**
 * Created by mihir.desai on 4/12/2018.
 */
public class NextGreatest {
    public static void nextGreatest(int[] a) {
        int nextGreatest = a[a.length - 1];
        a[a.length - 1] = - 1;

        for(int i = a.length - 2; i >= 0; --i) {
            int temp = a[i];
            a[i] = nextGreatest;
            if(temp > nextGreatest) {
                nextGreatest = temp;
            }
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

    public static void main(String[] args) {
        int[] A = new int[] {16,17,4,3,5,2};
        nextGreatest(A);
    }
}
