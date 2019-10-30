package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

import java.util.*;

public class FindMinDistanceSortedArrays {

    public static class ArrayData implements Comparable<ArrayData> {

        public int idx;
        public int val;

        public ArrayData(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(ArrayData o) {
            int result = Integer.compare(val , o.val);
            if (result == 0) {
                result = Integer.compare(idx , o.idx);
            }
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayData arrayData = (ArrayData) o;
            return idx == arrayData.idx &&
                    val == arrayData.val;
        }

        @Override
        public int hashCode() {

            return Objects.hash(idx, val);
        }
    }

    public static int findMinDistance(List<List<Integer>> A) {
        List<Integer> heads = new ArrayList<>(A.size());
        for(List<Integer> arr : A) {
            heads.add(0);
        }

        NavigableSet<ArrayData> currHeads = new TreeSet<>();
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < A.size(); i++) {
            currHeads.add(new ArrayData(i,A.get(i).get(heads.get(i))));
        }

        while(true) {
            result = Math.min(result, currHeads.last().val - currHeads.first().val);

            // get min idx and set head with minIdx + 1
            int nextMinIdx = currHeads.first().idx;
            heads.set(nextMinIdx,heads.get(nextMinIdx) + 1);

            // check if vindex of head at minIdx greater than actual size of indexed array then return result
            if(heads.get(nextMinIdx) >= A.get(nextMinIdx).size()) {
                return result;
            }

            // remove min
            currHeads.pollFirst();
            currHeads.add(new ArrayData(nextMinIdx,A.get(nextMinIdx).get(heads.get(nextMinIdx))));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();

        List<Integer> arr = new ArrayList<>(Arrays.asList(5,10,15));
        A.add(arr);

        arr = new ArrayList<>(Arrays.asList(3,6,9,12,15));
        A.add(arr);

        arr = new ArrayList<>(Arrays.asList(8,16,14));
        A.add(arr);

        StdOut.println(findMinDistance(A));


    }
}
