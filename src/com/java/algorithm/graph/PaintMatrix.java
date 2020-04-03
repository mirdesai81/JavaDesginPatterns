package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.*;

public class PaintMatrix {
    public static class Coordinate {
        public int x,y;

        public Coordinate(int x,int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }

            if(o == null || getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate) o;

            return this.x == that.x && this.y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }

        @Override
        public String toString() {
            return "[" +
                    "x=" + x +
                    ", y=" + y +
                    ']';
        }
    }

    public static void paintMatrix(List<List<Boolean>> A, int x, int y) {
        final int[][] DIRS = {{0,1},{0, -1},{1,0},{-1, 0}};
        boolean color = A.get(x).get(y);
        Queue<Coordinate> q = new LinkedList<>();
        A.get(x).set(y, !color);
        q.add(new Coordinate(x,y));

        while(!q.isEmpty()) {
            Coordinate curr = q.peek();

            for(int[] dir : DIRS) {
                Coordinate next = new Coordinate(curr.x + dir[0], curr.y + dir[1]);

                if(canFlip(next,A,color)) {
                    A.get(next.x).set(next.y, !color);
                    q.add(next);
                }
            }

            q.remove();
        }

    }

    private static boolean canFlip(Coordinate cur, List<List<Boolean>> A,boolean color) {
        return cur.x >= 0 && cur.x < A.size()
                && cur.y >= 0 && cur.y < A.get(cur.x).size()
                && A.get(cur.x).get(cur.y) == color;
    }

    public static void main(String[] args) {
        List<List<Boolean>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(false , true, false, false)));
        A.add(new ArrayList<>(Arrays.asList(false , true, true, false)));
        A.add(new ArrayList<>(Arrays.asList(false , false, true, false)));
        A.add(new ArrayList<>(Arrays.asList(false , false, true, true)));

        paintMatrix(A,2,1);

        StdOut.println(A);

    }

}
