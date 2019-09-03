package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mihir.Desai on 4/19/2018.
 */
public class MatrixSpiralOrder {

    public static List<Integer> matrixSpiralOrder(List<List<Integer>> squareMatrix) {
        List<Integer> spiralOrdering = new ArrayList<>();

        for(int offset = 0; offset < Math.ceil(0.5 * squareMatrix.size()); ++offset) {
            matrixClockwise(squareMatrix,offset,spiralOrdering);
        }

        return spiralOrdering;
    }

    public static void matrixClockwise(List<List<Integer>> squareMatrix,int offset,List<Integer> spiralOrdering) {
        int size = squareMatrix.size();
        if(offset == size - offset -1) {
            spiralOrdering.add(squareMatrix.get(offset).get(offset));
        }

        for(int j = offset; j < size - offset - 1; ++j) {
            spiralOrdering.add(squareMatrix.get(offset).get(j));
        }

        for(int i = offset; i < size - offset - 1; ++i) {
            spiralOrdering.add(squareMatrix.get(i).get(size - offset - 1));
        }

        for(int j = size - offset - 1; j > offset; --j) {
            spiralOrdering.add(squareMatrix.get(size - offset - 1).get(j));
        }

        for(int i = size - offset - 1; i > offset; --i) {
            spiralOrdering.add(squareMatrix.get(i).get(offset));
        }
    }

    public static List<Integer> matrixSpiralOrderDirection(List<List<Integer>> squareMatrix) {
        List<Integer> spiralOrdering = new ArrayList<>();
        final int[][] SHIFT = {{0,1} ,{1,0} , {0 , -1} , {-1, 0}};
        int x = 0, y = 0, dir = 0;

        for(int i = 0; i < squareMatrix.size() * squareMatrix.size(); ++i) {
            spiralOrdering.add(squareMatrix.get(x).get(y));
            squareMatrix.get(x).set(y,0);
            int nextX = x + SHIFT[dir][0];
            int nextY = y + SHIFT[dir][1];

            if(nextX < 0 || nextX >= squareMatrix.size()
                    || nextY < 0 || nextY >= squareMatrix.size()
                    || squareMatrix.get(nextX).get(nextY) == 0) {
                dir = (dir + 1) % 4;
                nextX = x + SHIFT[dir][0];
                nextY = y + SHIFT[dir][1];
            }

            x = nextX;
            y = nextY;
        }

        return spiralOrdering;
    }


    public static void main(String[] args) {
        List<List<Integer>> squareMatrix = new ArrayList<>();
        squareMatrix.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        squareMatrix.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
        squareMatrix.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));

        System.out.println(matrixSpiralOrderDirection(squareMatrix));
    }
}
