package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.HashMap;
import java.util.Map;

public class CoinsNumOfWays {

    public static void makeChange(int n) {
        int[] denoms = {25,10,5,1};
        int[][] map  = new int[n + 1][denoms.length];
        StdOut.println(makeChange(n,denoms,0,map));
        StdOut.println(makeChange(n,denoms,denoms.length - 1,new HashMap<>()));
    }

    public static int makeChange(int amount,int[] denoms,int index,int[][] map) {
        if(map[amount][index] > 0) return map[amount][index];

        if(index >= denoms.length - 1) return 1;

        int denomAmount = denoms[index];
        int ways = 0;
        for(int i = 0; i * denomAmount <= amount; i++) {
            int remainingAmount = amount - i * denomAmount;
            ways += makeChange(remainingAmount,denoms,index + 1,map);
        }

        map[amount][index] = ways;
        return ways;
    }

    public static int makeChange(int amount,int[] denoms,int index,Map<String,Integer> map) {
        // if total is 0, return 1 (solution found)
        if(amount == 0) return 1;

        if(index < 0 || amount < 0) return 0;

        String key = index + "|" + amount;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if(!map.containsKey(key)) {
            // include coin
            int include = makeChange(amount - denoms[index],denoms,index,map);

            // exclude coin
            int exclude = makeChange(amount,denoms,index - 1,map);

            map.put(key,include + exclude);
        }

        return map.get(key);
    }

    public static void main(String[] args) {
        makeChange(100);
    }
}
