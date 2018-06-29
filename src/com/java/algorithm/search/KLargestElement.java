package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.*;

public class KLargestElement {

    private static class Compare {

        private static class GreaterThan implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b) {
                return (a > b) ? -1 : (a.equals(b)) ? 0 : 1;
            }
        }

        public static final GreaterThan GREATER_THAN = new GreaterThan();
    }

    public static int findKLargest(List<Integer> A,int k) {
        return findKLargest(A,k,Compare.GREATER_THAN);
    }


    public static int findKLargest(List<Integer> A,int k,Comparator<Integer> cmp) {
        int left = 0;
        int right = A.size() - 1;
        Random r = new Random(0);
        while(left <= right) {
            int pivotIdx = r.nextInt(right - left + 1) + left;
            int newPivotIdx = partition(left,right,pivotIdx,A,cmp);
            if(newPivotIdx == k - 1) {
                return A.get(newPivotIdx);
            } else if(newPivotIdx > k -1) {
                right = newPivotIdx - 1;
            } else {
                left = newPivotIdx + 1;
            }
        }

        return -1;
    }

    public static int partition(int left,int right,int pivotIdx,List<Integer> A,Comparator<Integer> cmp) {
        int pivotValue = A.get(pivotIdx);
        int newPivotIdx = left;

        Collections.swap(A,pivotIdx,right);

        for(int i = left; i < right; i++) {
            if(cmp.compare(A.get(i),pivotValue) < 0) {
                Collections.swap(A,i,newPivotIdx++);
            }
        }

        Collections.swap(A,right,newPivotIdx);
        return newPivotIdx;

    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(2,3,1,4,5,6,10,12,14,15));
        StdOut.println(findKLargest(A,3));

    }
}
