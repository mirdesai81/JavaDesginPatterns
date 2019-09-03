package com.java.algorithm.array;

import java.util.*;

/**
 * Created by mihir.desai on 4/5/2018.
 */
public class MaxProfit {
    public static double maxProfit(List<Double> prices) {
      double maxProfit = 0.0;
      double minSoFar = Double.MAX_VALUE;
      double maxValue = Double.MIN_VALUE;
      double minValue = Double.MAX_VALUE;
      // find minSoFar for all entries
        // find maxProfit by finding max of maxProfit and  difference of ith price and minPriceSoFar

        for(int i = 0; i < prices.size();++i) {
            minSoFar = Math.min(minSoFar,prices.get(i));
            if(prices.get(i) - minSoFar > maxProfit) {
                maxValue = prices.get(i);
                minValue = minSoFar;
            }

            maxProfit = Math.max(maxProfit,prices.get(i) - minSoFar);

        }

        System.out.println("Min Price - "+minValue+" ,Max Price - "+maxValue+" ,Max Profit - "+maxProfit);
        return maxProfit;
    }

    public static double buyAndSellStockTwice(List<Double> prices) {
        double maxTotalProfit = 0.0;
        List<Double> firstBuySellProfits = new ArrayList<>();
        double minPrice = Double.MAX_VALUE;

        // first find max profit for buy and sell
        for(int i = 0; i < prices.size(); ++i) {
            Double price = prices.get(i);
            minPrice = Math.min(minPrice,price);
            maxTotalProfit = Math.max(maxTotalProfit, price - minPrice);
            firstBuySellProfits.add(maxTotalProfit);
            System.out.println("Price - "+price+" ,Min Price - "+minPrice+" ,Max Profit - "+maxTotalProfit);
        }

        //find max profit for each day if we make second buy and sell on that day.
        System.out.println("Profits 1st buy and sell - "+firstBuySellProfits);
        double maxPrice = Double.MIN_VALUE;
        for(int i = prices.size() - 1; i > 0; --i) {
            Double price = prices.get(i);
            maxPrice = Math.max(maxPrice,price);
            maxTotalProfit = Math.max(maxTotalProfit,maxPrice - price + firstBuySellProfits.get(i - 1));
            System.out.println("Price - "+price+" ,Max Price - "+maxPrice+" ,Max Profit - "+maxTotalProfit);
        }

        return maxTotalProfit;
    }

    public static int maxProfit(int prices[],int k) {
        int T[][] = new int[k + 1][prices.length];

        for(int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for(int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1],prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff,T[i-1][j] - prices[j]);
            }

        }

        printSolution(T,prices);
        return T[k][prices.length - 1];
    }

    public static void printSolution(int T[][],int[] prices){
        int i = T.length - 1;
        int j = T[0].length - 1;

        Deque<Integer> stack = new LinkedList<>();
        while(true) {
            if(i == 0 || j == 0) {
                break;
            }

            if(T[i][j] == T[i][j -1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                int maxDiff = T[i][j] - prices[j];
                for(int k = j -1; k >= 0; k--) {
                    if(T[i - 1][k] - prices[k] == maxDiff) {
                        i = i -1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }

            }
        }

        while(!stack.isEmpty()) {
            System.out.println("Buy at price - " + prices[stack.pollFirst()]);
            System.out.println("Sell at price - " + prices[stack.pollFirst()]);
        }
    }

    public static void main(String[] args) {
        //List<Double> prices = new ArrayList<>(Arrays.asList(310.0,315.0,275.0,295.0,260.0,270.0,290.0,230.0,255.0,250.0));
        //maxProfit(prices);


        //System.out.println(prices);
       // buyAndSellStockTwice(prices);

        int[] pricesK = new int[] {310,315,275,295,260,270,290,230,255,250};
        System.out.println(maxProfit(pricesK, 3));
    }
}
