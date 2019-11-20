package com.java.algorithm.recursion;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratePowerSet {

    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        List<List<Integer>> powerSet = new ArrayList<>();
        directedPowerSet(inputSet,0,new ArrayList<>(), powerSet);
        return powerSet;
    }


    private static void directedPowerSet(List<Integer> inputSet,int toBeSelected,List<Integer> selectedSoFar,List<List<Integer>> powerSet) {
        if(toBeSelected == inputSet.size()) {
            powerSet.add(new ArrayList<>(selectedSoFar));
            return;
        }

        selectedSoFar.add(inputSet.get(toBeSelected));
        directedPowerSet(inputSet,toBeSelected + 1,selectedSoFar,powerSet);
        selectedSoFar.remove(selectedSoFar.size() - 1);
        directedPowerSet(inputSet,toBeSelected + 1,selectedSoFar,powerSet);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(0,1,2));
        StdOut.println(generatePowerSet(A));
    }
}
