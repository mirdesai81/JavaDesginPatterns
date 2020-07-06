package com.java.algorithm.search;

import com.java.stdlib.StdOut;

public class SearchRotatedArray {

    // 10 20 30 5 6 7 9 10

    public static int search(int[] A,int left,int right,int x) {


            if(left > right) return -1;

            int mid = left + (right - left) / 2;

            if(A[mid] == x) {
                return mid;
            }

            if(A[left] < A[mid]) {
                if(x >= A[left] && x < A[mid]) {
                    return search(A,left,mid -1,x);
                } else {
                    return search(A,mid + 1,right,x);
                }
            } else if(A[left] > A[mid]) {
                if(x > A[mid] && x <= A[right]) {
                    return search(A,mid + 1,right,x);
                } else {
                    return search(A,left,mid - 1,x);
                }
            }

            return -1;
        }




    public static void main(String[] args) {
        int[] A = {10,11,20,30,5,6,7,8,9};
        StdOut.println(search(A,0,A.length - 1,11));
        StdOut.println(search(A,0,A.length - 1,7));


    }
}
