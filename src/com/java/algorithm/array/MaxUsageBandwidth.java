package com.java.algorithm.array;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxUsageBandwidth {
    public static class Usage {
        Integer start,end,bandwidth;

        public Usage(Integer start,Integer end,Integer bandwidth) {
            this.start = start;
            this.end= end;
            this.bandwidth = bandwidth;
        }

        @Override
        public String toString() {
            return "Usage{" +
                    "start=" + start +
                    ", end=" + end +
                    ", bandwidth=" + bandwidth +
                    '}';
        }
    }

    public static enum BoundaryType {
        START , END;
    }

    public static class Boundary implements Comparable<Boundary> {
        BoundaryType type;
        Integer time;
        Integer bandwidth;
        public Boundary(BoundaryType type,Integer time,Integer bandwidth) {
            this.type = type;
            this.time = time;
            this.bandwidth = bandwidth;
        }

        @Override
        public int compareTo(Boundary o) {
            int cmp = this.time.compareTo(o.time);

            if(cmp == 0) {
                return type.compareTo(o.type);
            }

            return cmp;
        }
    }

    public static int findPeakBandwidthUsage(List<Usage> A) {
        List<Boundary> boundaryList = new ArrayList<>();

        for(Usage usage : A) {
            boundaryList.add(new Boundary(BoundaryType.START,usage.start,usage.bandwidth));
            boundaryList.add(new Boundary(BoundaryType.END,usage.end,usage.bandwidth));
        }

        Collections.sort(boundaryList);
        Stack<Boundary> stack = new Stack<>();
        int bandwidthUsage = 0;
        Usage maxUsage = new Usage(0,0,-1);

        for(Boundary boundary : boundaryList) {
            if(boundary.type == BoundaryType.START) {
                stack.push(boundary);
                bandwidthUsage += boundary.bandwidth;
            } else {
                Boundary start = stack.pop();

                if(bandwidthUsage > maxUsage.bandwidth) {
                    maxUsage = new Usage(start.time,boundary.time,bandwidthUsage);
                }

                bandwidthUsage = bandwidthUsage - boundary.bandwidth;
            }
        }

        StdOut.println(maxUsage);
        return maxUsage.bandwidth;
    }


    public static void main(String[] args) {
        List<Usage> usages = new ArrayList<>();
        usages.add(new Usage(1,5,5));
        usages.add(new Usage(2,7,5));
        usages.add(new Usage(4,5,5));
        usages.add(new Usage(6,10,5));
        usages.add(new Usage(8,9,5));
        usages.add(new Usage(9,17,5));
        usages.add(new Usage(11,13,5));
        usages.add(new Usage(14,15,5));
        usages.add(new Usage(12,15,5));

        StdOut.println(findPeakBandwidthUsage(usages));
    }
}
