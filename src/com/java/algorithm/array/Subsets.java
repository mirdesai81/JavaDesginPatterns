package com.java.algorithm.array;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mihir.desai on 4/13/2018.
 */
public class Subsets {
    public static void printSubsets(char[] set) {
        int n = set.length;

        for(int i = 0; i < ( 1 << n); i++) {
            System.out.print("{");
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) > 0) {
                    System.out.print(set[j]+ " ");
                }
            }
            System.out.print("}");
        }
    }

    public static ArrayList<ArrayList<Character>> getSubsets(ArrayList<Character> set,int index) {
        ArrayList<ArrayList<Character>> allSubsets;
        if(set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<Character>());
        } else {
            allSubsets = getSubsets(set,index + 1);
            Character item = set.get(index);
            ArrayList<ArrayList<Character>> moreSubsets = new ArrayList<>();
            for(ArrayList<Character> currSubset : allSubsets) {
                ArrayList<Character> newSubset = new ArrayList<>();
                newSubset.addAll(currSubset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }

            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;
    }

    // Driver code
    public static void main(String[] args)
    {
        char set[] = {'a', 'b', 'c'};
        printSubsets(set);
        StdOut.println();
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('a','b','c'));
        StdOut.println(getSubsets(list,0));


    }
}
