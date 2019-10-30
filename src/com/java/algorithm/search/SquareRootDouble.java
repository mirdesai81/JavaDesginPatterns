package com.java.algorithm.search;

public class SquareRootDouble {

    private static enum Ordering {SMALLER , EQUAL, LARGER }

    private static Ordering compare(double a, double b) {
        final double EPSILION = 0.00001;
        double diff = (a-b)/b;

        return diff < -EPSILION ? Ordering.SMALLER :
                diff > EPSILION ? Ordering.LARGER : Ordering.EQUAL;
    }

    private static double squareRoot(double x) {
        double left,right;

        if(x < 1.0) {
            left = x;
            right = 1.0;
        } else {
            left = 1.0;
            right = x;
        }

        while(compare(left,right) == Ordering.SMALLER) {
            double mid = left + 0.5 * (right - left);
            double midSquareed = mid * mid;

            if(compare(midSquareed,x) == Ordering.EQUAL) {
                return mid;
            } else if(compare(midSquareed,x) == Ordering.LARGER) {
                right = mid;
            } else {
                right = left;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        System.out.println(squareRoot(50.0));

        System.out.println(squareRoot(1/4));
    }

}


