package com.java.algorithm.array;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.List;

public class MergingIntervals {
    public static class Interval {
        int left,right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[" + left +
                    ", " + right +
                    ']';
        }
    }

    public static List<Interval> mergeIntervals(List<Interval> A, Interval newInterval) {
        int i = 0;
        List<Interval> result = new ArrayList<>();
        while(i < A.size() && newInterval.left > A.get(i).right) {
            result.add(A.get(i++));
        }

        // overlapping interval
        while(i < A.size() && newInterval.right >= A.get(i).left) {
            newInterval = new Interval(
                    Math.min(newInterval.left,A.get(i).left),
                    Math.max(newInterval.right,A.get(i).right)
            );
            i++;
        }

        result.add(newInterval);

        result.addAll(A.subList(i,A.size()));

        return result;
    }

    public static void main(String[] args) {
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(-4,-1));
        A.add(new Interval(0,2));
        A.add(new Interval(3,6));
        A.add(new Interval(7,9));
        A.add(new Interval(11,12));
        A.add(new Interval(14,17));

        StdOut.println(mergeIntervals(A , new Interval(0,8)));
    }
}
