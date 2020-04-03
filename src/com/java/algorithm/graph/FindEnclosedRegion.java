package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.*;

public class FindEnclosedRegion {

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

    public static void fillSurrondedRegions(List<List<Character>> board) {
        if(board.isEmpty()) {
            return;
        }

        List<List<Boolean>> visited = new ArrayList<>(board.size());

        for(int i = 0; i < board.size(); i++) {
          visited.add(new ArrayList<>(Collections.nCopies(board.get(i).size(),false)));
        }

        // Identify regions that are reachable
        // via white path starting from first or last column

        for(int i = 0; i < board.size(); i++) {
            if(board.get(i).get(0) == 'W' && !visited.get(i).get(0)) {
                markBoundaryRegion(i, 0, board, visited);
            }


            if(board.get(i).get(board.get(i).size() - 1) == 'W' && !visited.get(i).get(board.get(i).size() - 1)) {
                markBoundaryRegion(i, board.size() - 1, board, visited);
            }
        }

        // Identify regions that are reachable
        // via white path starting from first or last row

        for(int j = 0; j < board.get(0).size(); j++) {
            if(board.get(0).get(j) == 'W' && !visited.get(0).get(j)) {
                markBoundaryRegion(0, j, board, visited);
            }


            if(board.get(board.size() - 1).get(j) == 'W' && !visited.get(board.size() - 1).get(j)) {
                markBoundaryRegion(board.size() - 1, j, board, visited);
            }
        }

        // Mark inner white region as black
        for(int i = 1; i < board.size() - 1; i++) {
            for (int j = 1; j < board.get(i).size() - 1; j++) {
                if (board.get(i).get(j) == 'W' && !visited.get(i).get(j)) {
                    board.get(i).set(j, 'B');
                }
            }
        }
    }

    private static void markBoundaryRegion(int i, int j,List<List<Character>> board,List<List<Boolean>> visited) {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(i,j));
        visited.get(i).set(j,true);
        final int[][] DIRS = {{0,1},{0, -1},{1,0},{-1, 0}};
        while(!q.isEmpty()) {
            Coordinate curr = q.poll();
            for(int[] dir : DIRS) {
                Coordinate next = new Coordinate(curr.x + dir[0],curr.y + dir[1]);
                if(next.x >= 0 && next.x < board.size()
                        && next.y >= 0 && next.y < board.get(next.x).size()
                        && board.get(next.x).get(next.y) == 'W'
                        && !visited.get(next.x).get(next.y)) {
                    q.add(next);
                    visited.get(next.x).set(next.y,true);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Character>> board = new ArrayList<>();
        board.add(new ArrayList<>(Arrays.asList('W' , 'B', 'B', 'B')));
        board.add(new ArrayList<>(Arrays.asList('B' , 'W', 'W', 'B')));
        board.add(new ArrayList<>(Arrays.asList('B' , 'B', 'B', 'B')));
        board.add(new ArrayList<>(Arrays.asList('B' , 'B', 'B', 'B')));
        StdOut.println("Before - "+board);
        fillSurrondedRegions(board);
        StdOut.println("After - " +board);
    }

}
