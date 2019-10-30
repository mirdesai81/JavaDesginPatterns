package com.java.algorithm.priorityQueue;

import com.java.stdlib.StdOut;

import java.util.*;

public class MergeSortedArrays {


    private static class ArrayEntry {
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getArrayId() {
            return arrayId;
        }

        public void setArrayId(Integer arrayId) {
            this.arrayId = arrayId;
        }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
        for(List<Integer> sortedArray : sortedArrays) {
            iters.add(sortedArray.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(),(a1, a2) -> Integer.compare(a1.value,a2.value));
        // Now add first entry from each iters to minHeap
        for(int i = 0; i < iters.size();i++) {
            if(iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(),i));
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            ArrayEntry entry = minHeap.poll();
            result.add(entry.getValue());
            Iterator<Integer> entryIter = iters.get(entry.getArrayId());
            if(entryIter.hasNext()) {
                minHeap.add(new ArrayEntry(entryIter.next(),entry.getArrayId()));
            }
        }

        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> sortedArrays = new ArrayList<>();

        List<Integer> arrays = new ArrayList<>();
        arrays.add(0);
        arrays.add(10);
        arrays.add(11);

        sortedArrays.add(arrays);

        arrays = new ArrayList<>();
        arrays.add(5);
        arrays.add(7);
        arrays.add(22);
        sortedArrays.add(arrays);

        arrays = new ArrayList<>();
        arrays.add(15);
        arrays.add(17);
        arrays.add(21);
        sortedArrays.add(arrays);

        StdOut.println(mergeSortedArrays(sortedArrays));
    }
}
