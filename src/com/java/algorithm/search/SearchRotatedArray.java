package com.java.algorithm.search;

import com.java.stdlib.StdOut;

public class SearchRotatedArray {

    // 10 20 30 5 6 7 9 10

    public static int search(int[] A,int left,int right,int x) {

            int mid = left + (right - left) / 2;
            if(A[mid] == x) return mid;

            if(left > right) return -1;



            if(A[left] < A[mid]) { // left is normally ordered
                if(x >= A[left] && x < A[mid]) {
                    // search left
                    return search(A,left,mid - 1,x);
                } else  {
                    // search right
                    return search(A,mid + 1,right,x);
                }
            } else if(A[mid] < A[left]) { // right is normally ordered
                if(x > A[mid] && x <= A[right]) {
                    // search right
                    return search(A,mid + 1,right,x);
                } else {
                    // search left
                    return search(A,left,mid - 1,x);
                }
            } else if(A[left] == A[mid]) { // all left is repeated
                if(A[mid] != A[right]) { // if right is not same search right
                    return search(A,mid + 1,right,x);
                } else {
                    // search both
                    int result = search(A,left,mid - 1,x);
                    if(result != -1) {
                        return result;
                    } else {
                        return search(A,mid + 1,right,x);
                    }
                }
            }

            return -1;
    }



    public static void main(String[] args) {
        int[] A = {10,11,11,11,20,30,5,6,7,8,9,10,10,10};
        StdOut.println(search(A,0,A.length - 1,11));
    }
}
