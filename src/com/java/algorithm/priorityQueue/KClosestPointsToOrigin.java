package com.java.algorithm.priorityQueue;

import java.util.*;



public class KClosestPointsToOrigin {

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            // ignoring sqrt
            return (x * x) + (y * y);
        }
    }

    public static List<Point> findClosestPoints(Point[] points, int k) {
        //ArrayList<Point> result = new ArrayList<>();
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k,(a , b) -> b.distFromOrigin() - a.distFromOrigin());
        for(int i = 0;i < k;i++) {
            maxHeap.add(points[i]);
        }

        for(int i = k; i < points.length; i++) {
            if(maxHeap.peek().distFromOrigin() > points[i].distFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}
