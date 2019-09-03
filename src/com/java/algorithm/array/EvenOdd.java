package com.java.algorithm.array;

public class EvenOdd {

    public static void evenOdd(int[] a) {
        int nextEven = 0, nextOdd = a.length - 1;
        while(nextEven < nextOdd) {
            if(a[nextEven] % 2 == 0) {
                nextEven++;
            } else if(a[nextOdd] % 2 == 0) {
                int temp = a[nextEven];
                a[nextEven] = a[nextOdd];
                a[nextOdd--] = temp;
            } else {
               nextOdd--;
            }
        }
    }



    public static void main(String[] args) {
        int[] a = {10,13,14,15,16,12,11,17,18,19,20};
        ArrayUtils.print("Before",a);
        evenOdd(a);
        ArrayUtils.print("After",a);
    }
}
