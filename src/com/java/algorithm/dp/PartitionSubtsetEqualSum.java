package com.java.algorithm.dp;

public class PartitionSubtsetEqualSum {

    public static boolean findPartition(int[] arr,int n) {
        int sum = 0;
        int i,j;

        for(i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if(sum % 2 != 0) {
            return false;
        }

        boolean[][] result = new boolean[sum/2 + 1][n + 1];

        for(i = 0; i <= n; i++) {
            result[0][i] = true;
        }

        for(i = 1; i <= sum/2; i++) {
            result[i][0] = false;
        }

        for(i = 1; i <= sum/2; i++) {
            for(j = 1; j <= n; j++) {
                result[i][j] = result[i][j - 1];
                if(i >= arr[j - 1]) {
                    result[i][j] = result[i][j] || result[i - arr[j - 1]][j - 1];
                }
            }
        }

        return result[sum/2][n];
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 1, 2, 2,1};
        int n = arr.length;
        if (findPartition(arr, n))
            System.out.println("Can be divided into two " +
                    "subsets of equal sum");
        else
            System.out.println("Can not be divided into" +
                    " two subsets of equal sum");
    }
}
