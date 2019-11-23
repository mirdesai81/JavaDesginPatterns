package com.java.algorithm.greedy;

import com.java.stdlib.StdOut;

public class CoinsChanging {

    public static int changeMaking(int cents) {
        final int[] COINS = {100, 50, 25, 10, 5, 1};
        int numCoins = 0;

        for(int i = 0; i < COINS.length; i++) {
            numCoins = numCoins + ( cents / COINS[i]);
            cents = cents % COINS[i];
        }

        return numCoins;
    }

    public static void main(String[] args) {
        StdOut.println(changeMaking(159));
    }


}
