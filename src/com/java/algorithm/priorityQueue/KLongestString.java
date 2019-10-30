package com.java.algorithm.priorityQueue;

import java.util.*;

public class KLongestString {
    public static List<String> KLongestString(int k, Iterator<String> iter) {
        PriorityQueue<String> pq = new PriorityQueue<>((s1,s2) -> Integer.compare(s1.length(),s2.length()));

        while(iter.hasNext()) {
            pq.add(iter.next());
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("Nita","Anya","Hina","Ojas","Mihir","Saloni","Rohit","Kaavya","Shital","Aditya"));
        System.out.println(KLongestString(4,input.iterator()));
    }
}
