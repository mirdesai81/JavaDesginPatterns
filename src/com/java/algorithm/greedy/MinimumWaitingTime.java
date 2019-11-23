package com.java.algorithm.greedy;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumWaitingTime {

    public static int minimumWaitingTime(List<Integer> serviceTimes) {
        Collections.sort(serviceTimes);
        int totalWaitingTime = 0;

        for(int i = 0; i < serviceTimes.size(); i++) {
            int numOfQueriesRemaining = serviceTimes.size() - (i + 1);
            totalWaitingTime += serviceTimes.get(i) * numOfQueriesRemaining;
        }

        return totalWaitingTime;
    }

    public static void main(String[] args) {
        List<Integer> serviceTimes = new ArrayList<>(Arrays.asList(2,5,1,3));
        StdOut.println(minimumWaitingTime(serviceTimes));
    }
}
