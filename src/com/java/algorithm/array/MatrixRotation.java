package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mihir.Desai on 4/25/2018.
 */
public class                                                                                                                                                                                                                                                                                                                                                                   MatrixRotation {
    public static void rotateMatrix(List<List<Integer>> squareMatrix) {
      /* final int matrixSize = squareMatrix.size() - 1;

       for(int i = 0; i < squareMatrix.size()/2;++i) {   // i = 0 and 1
           for(int j = i; j < matrixSize - i; j++) { // for i = 0; j = 0 , 1 ,2   for i = 1; j = 1
               int temp1 = squareMatrix.get(matrixSize - j).get(i);// for i = 0 , j = 0 and 1 temp1 will be 13 and 9
                int temp2 = squareMatrix.get(matrixSize - i).get(matrixSize - j); // for i = 0 , j = 0 and 1 temp2 will be 16,15
                int temp3 = squareMatrix.get(j).get(matrixSize - i); // for i = 0 , j = 0 and 1 temp3 will be 4,8
                int temp4 = squareMatrix.get(i).get(j); // for i = 0 , j = 0 and 1 temp2 will be 1,2

               // 13 to 1
               squareMatrix.get(i).set(j,temp1);
               // 1 to 4
               squareMatrix.get(j).set(matrixSize - i,temp4);
               // 4 to 16
               squareMatrix.get(matrixSize - i).set(matrixSize - j,temp3);

               // 16 to 13
               squareMatrix.get(matrixSize - j).set(i , temp2);

           }
       }*/

      int n = squareMatrix.size();

      for(int layer = 0; layer < n /2; layer++) {
          int first = layer;
          int last = n - 1 - layer;

          for(int i = first; i < last; i++) {
              int offset = i - first;


              int top = squareMatrix.get(first).get(i);
              squareMatrix.get(first).set(i,squareMatrix.get(last - offset).get(first));
              squareMatrix.get(last - offset).set(first,squareMatrix.get(last).get(last-offset));
              squareMatrix.get(last).set(last-offset , squareMatrix.get(i).get(last));
              squareMatrix.get(i).set(last,top);
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
