package com.java.algorithm.recursion;

import com.java.stdlib.StdOut;

public class PowerOfNumber {

    public static double power(int x,int n) {
        if(n == 0) return 1;

        if(n < 0) {
            double result = power(x,n * -1);
            return 1/result;
        }

        if(n % 2 == 0) {
            double result = power(x , n/2);
            return result * result;
        }


        return x * power(x, n - 1);
    }

    public static void main(String[] args) {

        StdOut.println(power(5,-2));

    }
}
