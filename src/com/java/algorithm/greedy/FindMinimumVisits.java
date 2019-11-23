package com.java.algorithm.greedy;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindMinimumVisits {

    private static class Interval {
        Integer left;
        Integer right;

        public Interval(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> findMinimumVisits(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.right,o2.right);
            }
        });
        List<Integer> visited = new ArrayList<>();
        Integer lastVisitedTime = intervals.get(0).right;
        visited.add(lastVisitedTime);

        for(Interval interval : intervals) {
            if(interval.left > lastVisitedTime) {
                lastVisitedTime = interval.right;
                visited.add(lastVisitedTime);
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        List<Interval>  intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(3,4));
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(3,4));
        intervals.add(new Interval(4,5));

        StdOut.println(findMinimumVisits(intervals));
    }
}
