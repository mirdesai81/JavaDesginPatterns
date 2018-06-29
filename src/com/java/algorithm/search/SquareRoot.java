package com.java.algorithm.search;

import com.java.stdlib.StdOut;

public class SquareRoot {

    public static int squareRoot(int k) {
        long left = 0, right = k;

        while(left <= right) {
            long mid = left + ((right - left)/2);
            long squareRoot = mid * mid;
            if(squareRoot <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) left - 1;
    }

    public static  void main(String[] args) {
        StdOut.println(squareRoot(300));
    }
}
