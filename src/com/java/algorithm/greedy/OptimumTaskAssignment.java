package com.java.algorithm.greedy;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OptimumTaskAssignment {
    private static class PairTask {
        Integer task1;
        Integer task2;

        public PairTask(Integer task1, Integer task2) {
            this.task1 = task1;
            this.task2 = task2;
        }

        @Override
        public String toString() {
            return "PairTask [" +
                    "task1=" + task1 +
                    ", task2=" + task2 +
                    ']';
        }
    }

    public static List<PairTask> optimumTaskAssignment(List<Integer> taskDurations) {
        Collections.sort(taskDurations);
        int i = 0;
        int j = taskDurations.size() - 1;
        List<PairTask> result = new ArrayList<>();
        while(i < j) {
            result.add(new PairTask(taskDurations.get(i), taskDurations.get(j)));
            ++i;
            --j;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> tasks = new ArrayList<>(Arrays.asList(5,2,1,6,4,4));
        StdOut.println(optimumTaskAssignment(tasks));
    }
}
