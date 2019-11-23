package com.java.algorithm.invariants;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MajoritySearch {

    public static String majoritySearch(Iterator<String> sequence) {
        String candidate = "";
        String iter;
        int candidateCount = 0;
        while(sequence.hasNext()) {
            iter = sequence.next();
            if(candidateCount == 0) {
                candidate = iter;
                candidateCount = 1;
            } else if(candidate.equals(iter)) {
                ++candidateCount;
            } else {
                --candidateCount;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        List<String> sequence = new ArrayList<>(Arrays.asList("b","a","c","a","a","b","a","a","c","a"));
        StdOut.println(majoritySearch(sequence.iterator()));

    }
}
