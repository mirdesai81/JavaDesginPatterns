package com.java.algorithm.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

class findKClosestPoints {
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        int x = Math.abs(a[0]*a[0])+Math.abs(a[1]*a[1]);
                        int y = Math.abs(b[0]*b[0])+Math.abs(b[1]*b[1]);
                        return x < y ? 1 : ((x == y) ? 0 : -1);
                    }
                });

        for(int i = 0; i < points.length; i++) {
            maxHeap.add(points[i]);
            if(maxHeap.size() == K + 1) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[K][];
        for(int i = 0; i < K; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {{3,3},{5,-1},{-2 , 4}};
        System.out.println(kClosest(points,2));
    }

}