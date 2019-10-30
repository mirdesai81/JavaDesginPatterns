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

        PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>(16,(a, b) -> Integer.compare(b.value, a.value));
        // always largest in the k largest;
        maxHeap.add(new HeapEntry(0,A.get(0)));
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            HeapEntry heapEntry = maxHeap.poll();
            result.add(heapEntry.value);
            int leftIdx = 2 * heapEntry.index + 1;
            int rightIdx = 2 * heapEntry.index + 2;
            if(leftIdx < A.size()) {
                maxHeap.add(new HeapEntry(leftIdx,A.get(leftIdx)));
            }

            if(rightIdx < A.size()) {
                maxHeap.add(new HeapEntry(rightIdx, A.get(rightIdx)));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(561,314,401,28,156,359,271,11,3));
        System.out.println(kLargestInBinaryHeap(input,6));

    }
}
