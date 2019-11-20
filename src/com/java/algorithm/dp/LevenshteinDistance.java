package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.Arrays;

public class LevenshteinDistance {

    public static int levenshteinDistance(String A,String B) {
        int[][] distanceBetweenPrefixes = new int[A.length()][B.length()];
        for(int[] row : distanceBetweenPrefixes) {
            Arrays.fill(row, -1);
        }

        return computeDistanceBetweenPrefixes(A, A.length() - 1,B, B.length() - 1,distanceBetweenPrefixes);
    }

    private static int computeDistanceBetweenPrefixes(String A,int A_idx,String B,int B_idx, int[][] distanceBetweenPrefixes) {
        if(A_idx < 0) {
            // A is empty so add all B's characters
            return B_idx + 1;
        } else if(B_idx < 0) {
            // B is empty so delete All A's characters
            return A_idx + 1;
        }

        if(distanceBetweenPrefixes[A_idx][B_idx] == -1) {
            if(A.charAt(A_idx) == B.charAt(B_idx)) {
                distanceBetweenPrefixes[A_idx][B_idx] = computeDistanceBetweenPrefixes(A, A_idx - 1, B, B_idx - 1,distanceBetweenPrefixes);
            } else {
                int substituteLast = computeDistanceBetweenPrefixes(A, A_idx - 1,B, B_idx - 1,distanceBetweenPrefixes);

                int addLast = computeDistanceBetweenPrefixes(A,A_idx,B,B_idx - 1,distanceBetweenPrefixes);

                int deleteLast = computeDistanceBetweenPrefixes(A, A_idx - 1,B, B_idx,distanceBetweenPrefixes);

                distanceBetweenPrefixes[A_idx][B_idx] = 1 + Math.min(substituteLast,Math.min(addLast,deleteLast));
            }
        }

        return distanceBetweenPrefixes[A_idx][B_idx];
    }

    public static void main(String[] args) {
        StdOut.println(levenshteinDistance("Carthorse", "Orchestra"));
    }
}
