package com.java.algorithm.priorityQueue;

import java.util.*;

public class KLargestInBinaryHeap {

    private static class HeapEntry {
        public Integer index;
        public Integer value;

        public HeapEntry(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    private static class Compare implements Comparator<HeapEntry> {
        @Override
        public int compare(HeapEntry o1, HeapEntry o2) {
            return Integer.compare(o2.value,o1.value);
        }

        public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
    }

    public static List<Integer> kLargestInBinaryHeap(List<Integer> A,int k) {
        if(k < 0) {
            return Collections.EMPTY_LIST;
        }

        PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<>(16,Compare.COMPARE_HEAP_ENTRIES);
        candidateMaxHeap.add(new HeapEntry(0,A.get(0)));
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < k;++i) {
            Integer index = candidateMaxHeap.peek().index;
            result.add(candidateMaxHeap.remove().index);
            Integer leftIndex = 2*i + 1;
            if(leftIndex < A.size()) {
                candidateMaxHeap.add(new HeapEntry(leftIndex,A.get(leftIndex)));
            }

            Integer rightIndex = 2*i + 2;
            if(rightIndex < A.size()) {
                candidateMaxHeap.add(new HeapEntry(rightIndex,A.get(rightIndex)));
            }
        }

        return result;
    }
}
