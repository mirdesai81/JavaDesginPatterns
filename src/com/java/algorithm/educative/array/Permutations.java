package com.java.algorithm.educative.array;

import java.util.*;

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
       List<List<Integer>> results = new ArrayList<>();
       Queue<List<Integer>> permutations = new LinkedList<>();
       permutations.add(new ArrayList<>());

        for (int currentNumber : nums) {
            // we will take all existing permutations and add the current number to create new permutations
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                // create a new permutation by adding the current number at every position
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    if (newPermutation.size() == nums.length)
                        results.add(newPermutation);
                    else
                        permutations.add(newPermutation);
                }
            }
        }

       return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
