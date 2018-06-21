package com.java.algorithm.priorityQueue;

import com.java.stdlib.StdOut;

import java.util.*;

public class SortApproximatelySortedData {

    public static List<Integer> sortApproximatelysortedData(List<Integer> A,int k) {
        Iterator<Integer> sequence = A.iterator();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k && sequence.hasNext(); ++i) {
            minPQ.add(sequence.next());
        }

        while (sequence.hasNext()) {
            minPQ.add(sequence.next());
            result.add(minPQ.remove());
        }

        while(!minPQ.isEmpty()) {
            result.add(minPQ.remove());
        }

        return  result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,-1,2,6,4,5,8));
        StdOut.println(sortApproximatelysortedData(list,2));
    }
}
