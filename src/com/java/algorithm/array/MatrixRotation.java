package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mihir.Desai on 4/25/2018.
 */
public class MatrixRotation {
    public static void rotateMatrix(List<List<Integer>> squareMatrix) {
        final int matrixSize = squareMatrix.size() - 1;
        for(int i = 0; i < squareMatrix.size()/2; ++i) {
            for(int j = i; j < matrixSize - i; ++j) {
                System.out.println("i="+i+"j="+j);
                int temp1 = squareMatrix.get(matrixSize - j).get(i);
                int temp2 = squareMatrix.get(matrixSize - i).get(matrixSize - j);
                int temp3 = squareMatrix.get(j).get(matrixSize - i);
                int temp4 = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, temp1);
                squareMatrix.get(matrixSize - j).set(i, temp2);
                squareMatrix.get(matrixSize - i).set(matrixSize - j, temp3);
                squareMatrix.get(j).set(matrixSize - i, temp4);
                System.out.println("temp1="+temp1+",temp2="+temp2+",temp3="+temp3+",temp4="+temp4);

            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> squareMatrix = new ArrayList<>();
        squareMatrix.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4)));
        squareMatrix.add(new ArrayList<Integer>(Arrays.asList(5,6,7,8)));
        squareMatrix.add(new ArrayList<Integer>(Arrays.asList(9,10,11,12)));
        squareMatrix.add(new ArrayList<Integer>(Arrays.asList(13,14,15,16)));
        rotateMatrix(squareMatrix);

        for(int i = 0; i < squareMatrix.size(); ++i) {
            System.out.println(squareMatrix.get(i));
        }

    }

}
