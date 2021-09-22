package com.java.algorithm.educative.dp;

public class Knapsack {

   /* public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        return solveKnapsack(dp,profits,weights,capacity);
    }

    public static int solveKnapsack(int[][] dp, int[] profits,int[] weights, int capacity) {
        int n = profits.length;

        // capacity 0
        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        // first weight
        for(int j = 0; j <= capacity; j++) {
            if(weights[0] <= j) {
                dp[0][j] = profits[0];
            } else {
                dp[0][j] = 0;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= capacity; j++) {
                int profit1 = 0 , profit2 = 0;
                // include current if weight is less than equal to capacity
                if(weights[i] <= j) {
                    profit1 = profits[i] + dp[i - 1][j - weights[i]];
                }

                profit2 = dp[i - 1][j];

                dp[i][j] = Math.max(profit1, profit2);
            }
        }

        return dp[n - 1][capacity];
    }
*/

    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[] dp = new int[capacity + 1];
        return solveKnapsack(dp,profits,weights,capacity);
    }

    public static int solveKnapsack(int[] dp, int[] profits,int[] weights, int capacity) {
        int n = profits.length;



        // first weight
        for(int j = 0; j <= capacity; j++) {
            if(weights[0] <= j) {
                dp[j] = profits[0];
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = capacity; j >= 0; j--) {
                int profit1 = 0 , profit2 = 0;
                // include current if weight is less than equal to capacity
                if(weights[i] <= j) {
                    profit1 = profits[i] + dp[j - weights[i]];
                }

                profit2 = dp[j];

                dp[j] = Math.max(profit1, profit2);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
