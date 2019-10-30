package com.java.algorithm.array;

public class FindMedianSortedArrays {

    private static double findMedianSortedArrays(int[] A, int[] B) {

        if(A.length > B.length) {
            return findMedianSortedArrays(B,A);
        }

        int x = A.length;
        int y = B.length;
        int low = 0;
        int high = x;

        while(low <= high) {
            int partitionX = (low + high)/2;
            // partitionX + partitionY = (x + y + 1)/2
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : A[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : A[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : B[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : B[partitionY];
            /*
               maxLeftX | minRightX
               maxLeftY | minRightY

             */

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {


                if((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX,maxLeftY);
                }

            } else if(maxLeftX > minRightY) { // we are too far on right side for partitionX Go on left side
                high = partitionX - 1;
            } else { // we are too far on left side for partitionX Go on right side
                low = partitionX + 1;
            }

        }

        throw new IllegalArgumentException("NO Solution found");
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,5,6};
        int[] B = {};

        System.out.println(FindMedianSortedArrays.findMedianSortedArrays(A,B));
    }
}
