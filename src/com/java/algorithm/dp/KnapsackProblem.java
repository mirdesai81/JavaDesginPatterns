package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {

    private static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int optimumSubjectToCapacity(List<Item> items, int capacity) {

        int[][] V = new int[items.size()][capacity + 1];

        for(int[] v : V) {
            Arrays.fill(v, 0);
        }

         return optimumSubjectToItemAndCapacity(items,items.size() - 1,capacity,V);
    }

    private static int optimumSubjectToItemAndCapacity(List<Item> items,int k,int availableCapacity,int[][] V) {

        for(int i = 0; i < items.size(); i++ ) {
            for(int j = 0; j <= availableCapacity; j++) {
                if(i == 0) {
                    if(j >= items.get(i).weight) {
                        V[i][j] = items.get(i).value;
                    } else {
                        V[i][j] = 0;
                    }
                } else {
                    // if weight of current item is less than current capacity then take max relation
                    if(items.get(i).weight <= j) {
                        int withoutThisItem = V[i - 1][j];
                        int withThisItem = V[i - 1][j - items.get(i).weight] + items.get(i).value;
                        V[i][j] = Math.max(withoutThisItem,withThisItem);
                    } else {
                        V[i][j] = V[i - 1][j];
                    }

                }
            }
        }

        return V[k][availableCapacity];
    }

    public static int optimumSubjectToItemAndCapacityEfficientSpace(List<Item> items,int availableCapacity) {
        int[] V = new int[availableCapacity + 1];

        for(int i = 0; i < items.size(); i++ ) {
            for(int j = 0; j <= availableCapacity; j++) {
                if(i == 0) {
                    if(j >= items.get(i).weight) {
                        V[j] = items.get(i).value;
                    } else {
                        V[j] = 0;
                    }
                } else {
                    // if weight of current item is less than current capacity then take max relation
                    if(items.get(i).weight <= j) {
                        int withoutThisItem = V[j];
                        int withThisItem = V[j - items.get(i).weight] + items.get(i).value;
                        V[j] = Math.max(withoutThisItem,withThisItem);
                    } else {
                        V[j] = j == 0 ? 0 : Math.max(V[j - 1],V[j]);
                    }

                }
            }
        }

        return V[availableCapacity];
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>(Arrays.asList(new Item(5,60),new Item(3,50),
                new Item(4,70),new Item(2,30)));
        StdOut.println(optimumSubjectToCapacity(items,5));
        StdOut.println(optimumSubjectToItemAndCapacityEfficientSpace(items,5));
    }
}
