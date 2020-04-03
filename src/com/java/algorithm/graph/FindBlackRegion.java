package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.*;

public class FindBlackRegion {
    public static int count = 0;

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

    public static enum Color {WHITE , BLACK}


    public static void findBlackRegion(List<List<Color>> matrix,int i,int j,List<List<Boolean>> visited) {
        int[][] DIRS = new int[][] {{-1,-1}, {-1, 0} , {-1,1},
                                        {0, -1} ,{0,1},
                {1,-1} ,{1 , 0} , {1,1}};
        Stack<Coordinate> stack = new Stack<>();
        stack.add(new Coordinate(i,j));
        visited.get(i).set(j,true);
        Coordinate curr;
        while(!stack.isEmpty()){
            curr = stack.pop();

            for(int[] dir : DIRS) {
                Coordinate next = new Coordinate(curr.x + dir[0] , curr.y + dir[1]);
                if(isFeasible(matrix,next.x, next.y,visited)) {
                    ++count;
                    visited.get(next.x).set(next.y,true);
                    stack.push(next);
                }
            }
        }
    }

    public static boolean isFeasible(List<List<Color>> matrix,int i,int j,List<List<Boolean>> visited) {
        return (i >= 0 && i < matrix.size()
                && j >= 0 && j < matrix.get(i).size()
                && !visited.get(i).get(j)
                && matrix.get(i).get(j) == Color.BLACK
                );
    }



    public static void main(String[] args) {
        List<List<Color>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(Color.WHITE , Color.WHITE, Color.BLACK, Color.BLACK)));
        matrix.add(new ArrayList<>(Arrays.asList(Color.BLACK , Color.WHITE, Color.WHITE, Color.BLACK)));
        matrix.add(new ArrayList<>(Arrays.asList(Color.BLACK , Color.BLACK, Color.WHITE, Color.BLACK)));
        matrix.add(new ArrayList<>(Arrays.asList(Color.BLACK , Color.BLACK, Color.WHITE, Color.WHITE)));

        List<List<Boolean>> visited = new ArrayList<>(matrix.size());

        for(int i = 0; i < matrix.size(); i++) {
            visited.add(i,new ArrayList<>(Collections.nCopies(matrix.get(i).size(),false)));
        }


        int result = 0;
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.get(i).size(); j++) {
                if(isFeasible(matrix,i,j,visited)) {
                    count = 1;
                    findBlackRegion(matrix, i, j, visited);
                    result = Math.max(count, result);
                }
            }
        }

        StdOut.println(result);
    }
}
