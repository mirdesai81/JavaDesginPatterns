package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestNonDecreasingSubsequence {

    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLengthEfficient(int A[], int size)
    {
        // Add boundary case, when array size is one

        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }

    public static int longestIncreasingSubsequenceLength(int[] A) {
        Integer[] maxLength = new Integer[A.length];
        Arrays.fill(maxLength,1);

        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if(A[i] >= A[j]) {
                    maxLength[i] = Math.max(maxLength[i],maxLength[j] + 1);
                }
            }
        }

        return Collections.max(Arrays.asList(maxLength));
    }


    public static List<Integer> longestIncreasingSubsequence(int[] A) {
        List<List<Integer>> result = new ArrayList<>(A.length);
        result.add(0,Collections.singletonList(A[0]));

        for(int i = 1; i < A.length; i++) {
            result.add(i,new ArrayList<>());
        }

        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if(A[i] >= A[j] &&
                        (result.get(i).size() < result.get(j).size() + 1)
                        ) {
                    result.add(i,new ArrayList(result.get(j)));
                }
            }



            result.get(i).add(A[i]);

        }

        List<Integer> max = result.get(0);

        for(int i = 1; i < result.size(); i++) {
            if(result.get(i).size() > max.size()) {
                max = result.get(i);
            }
        }

        return max;
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLengthEfficient(A, n));
        System.out.println("Length of Longest Increasing Subsequence is " + longestIncreasingSubsequenceLength(A));

        StdOut.println(longestIncreasingSubsequence(A));
    }
}
