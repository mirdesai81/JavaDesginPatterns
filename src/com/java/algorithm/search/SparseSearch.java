package com.java.algorithm.search;

import com.java.stdlib.StdOut;

public class SparseSearch {

    public static int search(String[] A,int left,int right,String x) {
        if(left > right ) return -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            // find first non empty on left and right
            if(A[mid].isEmpty()) {
                int leftIndex = mid - 1;
                int rightIndex = mid + 1;

                while(true) {
                    if(leftIndex >= left && !A[leftIndex].isEmpty()) {
                        mid = leftIndex;
                        break;
                    } else if(rightIndex <= right && !A[rightIndex].isEmpty()) {
                        mid = rightIndex;
                        break;
                    } else if(leftIndex < left && rightIndex > right ) {
                        return -1;
                    }
                    leftIndex--;
                    rightIndex++;
                }
            }

            if(A[mid].equals(x)) {
                return mid;
            } else if(A[mid].compareTo(x) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] input = {"at", "", "", "", "ball", "car","","","","" , "" , "cat", "dad", ""};
        StdOut.println(search(input,0,input.length - 1,"ball"));
        StdOut.println(search(input,0,input.length - 1,"cat"));
    }
}
