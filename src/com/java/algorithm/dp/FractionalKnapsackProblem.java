package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.*;

public class FractionalKnapsackProblem {

    private static class Item  {
        private Integer weight;
        private Integer value;
        private Double cost;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
            this.cost = (double) value / weight;
        }


    }

    public static double fractionalKnapsack(List<Item> items, int capacity) {

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

      double totalValue = 0d;
      for(Item item : items) {
          int currWt = item.weight;
          int currVal = item.value;

          if(capacity - currWt >= 0) {
              capacity = capacity - currWt;
              totalValue += currVal;
          } else {
              double fraction = ((double)capacity / (double)currWt);
              totalValue += currVal * fraction;
              capacity = (int) (capacity - currWt * fraction);
              break;
          }

      }

      return totalValue;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>(Arrays.asList(new Item(5,60),new Item(3,50),
                new Item(4,70),new Item(2,30)));
        StdOut.println(fractionalKnapsack(items,5));

    }

}
