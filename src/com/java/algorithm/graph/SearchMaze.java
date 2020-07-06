package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.*;

public class SearchMaze {
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

    public static List<Coordinate> searchMaze(List<List<Color>> maze,Coordinate s, Coordinate e) {
        List<Coordinate> path = new ArrayList<>();


        searchMazeHelper(maze,s,e,path);

        return path;
    }

    public static boolean searchMazeHelper(List<List<Color>> maze,Coordinate s, Coordinate e,List<Coordinate> path) {
        Stack<Coordinate> stack = new Stack<>();
        stack.add(s);
        final int[][] SHIFT = {{0 , 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!stack.isEmpty()) {
            Coordinate curr = stack.pop();
            if(curr.equals(e)) {
                path.add(curr);
                return true;
            } else if(isFeasible(curr,maze)) {
                path.add(curr);
                maze.get(curr.x).set(curr.y,Color.BLACK);

                for(int[] nextMove : SHIFT) {
                    Coordinate next = new Coordinate(curr.x + nextMove[0],curr.y + nextMove[1]);
                    if(isFeasible(next,maze)) {
                        stack.add(next);
                    }
                }

            } else {
                path.remove(path.size() - 1);
            }
        }

        return false;
    }

    private static boolean isFeasible(Coordinate cur,List<List<Color>> maze) {
        return cur.x >= 0 && cur.x < maze.size()
                    && cur.y >= 0 && cur.y < maze.get(cur.x).size()
                    && maze.get(cur.x).get(cur.y) == Color.WHITE;
    }

    public static void main(String[] args) {
        List<List<Color>> maze = new ArrayList<>();
        maze.add(new ArrayList<>(Arrays.asList(Color.WHITE , Color.WHITE, Color.BLACK, Color.BLACK)));
        maze.add(new ArrayList<>(Arrays.asList(Color.BLACK , Color.WHITE, Color.WHITE, Color.BLACK)));
        maze.add(new ArrayList<>(Arrays.asList(Color.BLACK , Color.BLACK, Color.WHITE, Color.BLACK)));
        maze.add(new ArrayList<>(Arrays.asList(Color.BLACK , Color.BLACK, Color.WHITE, Color.WHITE)));

        StdOut.println(searchMaze(maze,new Coordinate(0,0), new Coordinate(3,3)));

    }

}
