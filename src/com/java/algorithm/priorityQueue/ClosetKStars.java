package com.java.algorithm.priorityQueue;

import com.java.stdlib.StdOut;

import java.util.*;

public class ClosetKStars {
    private static class Star implements Comparable<Star> {
        private double x , y, z;

        public Star(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance() {
            return Math.sqrt(x*x + y*y + z*z);
        }



        @Override
        public int compareTo(Star star) {
            return Double.compare(this.distance(),star.distance());
        }

        @Override
        public String toString() {
            return "Star [" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    ", distance=" + this.distance() +
                    ']';
        }
    }

    public static List<Star> findClosetKStars(int k, List<Star> stars) {
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        Iterator<Star> iter = stars.iterator();

        while(iter.hasNext()) {
            maxHeap.add(iter.next());
            if(maxHeap.size() == k + 1) {
                maxHeap.remove();
            }
        }


        List<Star> orderedStars = new ArrayList<>(maxHeap);
        // sort the stars by distance
        Collections.sort(orderedStars);
        return orderedStars;
    }

    public static void main(String[] args) {
        List<Star> stars = new ArrayList<>();
        stars.add(new Star(1.21,1.21, 1.21));
        stars.add(new Star(1.2,1.2, 1.2));
        stars.add(new Star(1.1,1.1, 1.1));
        stars.add(new Star(1.41,1.41, 1.41));
        stars.add(new Star(1.51,1.51, 1.51));
        stars.add(new Star(1.61,1.61, 1.61));
        stars.add(new Star(1.01,1.01, 1.01));
        stars.add(new Star(1.13,1.13, 1.13));
        stars.add(new Star(1.05,1.05, 1.05));
        stars.add(new Star(1.12,1.12, 1.11));
        stars.add(new Star(1.03,1.03, 1.03));

        StdOut.println(findClosetKStars(3,stars));

    }
}
