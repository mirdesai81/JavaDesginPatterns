package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.HashSet;
import java.util.Set;

public class SearchSequenceIn2DArray {

    public static class Attempt {
        int x;
        int y;
        int offset;

        public Attempt(int x, int y, int offset) {
            this.x = x;
            this.y = y;
            this.offset = offset;
        }
    }

    public static boolean isSequenceContainedInGrid(int[][] grid,int[] pattern) {
        Set<Attempt> previousAttempts = new HashSet<>();
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(isPatternSuffixContainedStartingAtXY(grid,i,j,pattern,0,previousAttempts,visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isPatternSuffixContainedStartingAtXY(int[][] grid,int x, int y,
                                                                int[] pattern, int offset, Set<Attempt> previousAttempts,int[][] visited) {
        if(pattern.length == offset) {
            return true;
        }

        // Check if (x,y) lies outside grid
        if(x < 0 || x > grid.length
                || y < 0 || y > grid[x].length
                || previousAttempts.contains(new Attempt(x , y, offset))
                || visited[x][y] == 1) {
            return false;
        }

        visited[x][y] = 1;
        if(grid[x][y] == pattern[offset]
                && (
                        isPatternSuffixContainedStartingAtXY(grid,x - 1,y,pattern,offset + 1,previousAttempts,visited)
                || isPatternSuffixContainedStartingAtXY(grid,x + 1,y,pattern,offset + 1,previousAttempts,visited)
                || isPatternSuffixContainedStartingAtXY(grid,x ,y - 1,pattern,offset + 1,previousAttempts,visited)
                || isPatternSuffixContainedStartingAtXY(grid,x ,y + 1,pattern,offset + 1,previousAttempts,visited)
                )
                ) {
            return true;
        }

        previousAttempts.add(new Attempt(x,y,offset));
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{3,4,5},{5,6,7}};
        int[] pattern = {1,3,4,6};
        StdOut.println(isSequenceContainedInGrid(grid,pattern));
    }
}
