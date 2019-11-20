package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DivideSpoilsFairly {

    private static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }


    public static int minimizeDifference(List<Item> A) {
        int sum = 0;
        for(Item item : A) {
            sum += item.value;
        }

        Set<Integer> result = new HashSet<>();
        result.add(0);

        for(Item item : A) {
            for(int i = sum/2; i >= item.value; i--) {
                if(result.contains(i - item.value)) {
                    result.add(i);
                }
            }
        }

        for(int i = sum/2; i > 0;i--) {
            if(result.contains(i)) {
                return (sum - i) - i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(20,65));
        items.add(new Item(8,35));
        items.add(new Item(60,245));
        items.add(new Item(55,195));
        items.add(new Item(40,65));
        items.add(new Item(70,150));
        items.add(new Item(85,275));
        items.add(new Item(25,155));
        items.add(new Item(30,120));
        items.add(new Item(65,320));
        items.add(new Item(75,75));
        items.add(new Item(40,10));
        items.add(new Item(95,200));
        items.add(new Item(50,100));
        items.add(new Item(40,220));
        items.add(new Item(10,99));
        StdOut.println(minimizeDifference(items));
    }
}
