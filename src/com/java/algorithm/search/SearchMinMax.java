package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchMinMax {

    private static class MinMax {
        public Integer min;
        public Integer max;

        public MinMax(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        private static MinMax minMax(Integer a,Integer b) {
            return Integer.compare(b,a) < 0 ? new MinMax(b,a) : new MinMax(a,b);
        }

        @Override
        public String toString() {
            return "MinMax [" +
                    "min=" + min +
                    ", max=" + max +
                    ']';
        }
    }

    public static MinMax findMinMax(List<Integer> A) {
        if(A.size() <= 1) {
            return new MinMax(A.get(0),A.get(0));
        }

        MinMax global = MinMax.minMax(A.get(0),A.get(1));

        for(int i = 2; i + 1 < A.size(); i = i + 2) {
            MinMax currentMinMax = MinMax.minMax(A.get(i),A.get(i + 1));
            global = new MinMax(Math.min(global.min,currentMinMax.min),Math.max(global.max,currentMinMax.max));
        }

        if(A.size() % 2 != 0) {
            global = new MinMax(Math.min(global.min,A.get(A.size() - 1)),Math.max(global.max,A.get(A.size() - 1)));
        }

        return global;
    }

    public static void main(String[] args) {
        StdOut.println(findMinMax(new ArrayList<>(Arrays.asList(3,2,5,1,2,4))));
    }
}
