package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumRevenueCoins {
    public static int pickUpCoins(List<Integer> coins) {

        return computeMaximumRevenueForRange(coins,0,coins.size() - 1,new int[coins.size()][coins.size()]);
    }

    private static int computeMaximumRevenueForRange(List<Integer> coins,int a, int b, int[][] maximumRevenueForRange) {
        if(a > b ) {
            return 0;
        }

        if(maximumRevenueForRange[a][b] == 0) {
            int maximumRevenueA = coins.get(a) +
                    Math.min(computeMaximumRevenueForRange(coins ,a + 2,b,maximumRevenueForRange)
                    , computeMaximumRevenueForRange(coins, a + 1, b - 1,maximumRevenueForRange)
                    );

            int maximumRevenueB = coins.get(b) +
                    Math.min(computeMaximumRevenueForRange(coins,a + 1,b - 1,maximumRevenueForRange)
                            , computeMaximumRevenueForRange(coins,a,b - 2,maximumRevenueForRange));
            maximumRevenueForRange[a][b] = Math.max(maximumRevenueA,maximumRevenueB);
        }

        return maximumRevenueForRange[a][b];
    }

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>(Arrays.asList(10,25,1,10,5));
        StdOut.println(pickUpCoins(coins));
    }
}
