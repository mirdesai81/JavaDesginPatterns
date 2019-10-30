package com.java.algorithm.search;

import com.java.stdlib.StdOut;

public class SquareRoot {

    public static int squareRoot(int k) {
        int low = 0;
        int high = k;
        int mid = 0;
        int square = 0;
        while(low <= high) {
            mid = low + (high - low)/2;
            square = mid * mid;
            if(square <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low - 1;
    }

    public static  void main(String[] args) {
        StdOut.println(squareRoot(300));
    }
}
