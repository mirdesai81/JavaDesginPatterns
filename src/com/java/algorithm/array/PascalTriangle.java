package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihir.Desai on 4/30/2018.
 */
public class PascalTriangle {

    public static List<List<Integer>> generatePascalTriangle(int rows) {

        // for each row value = 1 if j = 0 or j = i
        // else sum of jth and j-1th value from previous row ( i - 1) of pascal triangle
        List<List<Integer>> pascalTriangle = new ArrayList<>(rows);
        for(int i = 0; i < rows; ++i) {
            List<Integer> currRow = new ArrayList<>();
            for(int j = 0 ; j <= i; j++) {
                currRow.add(0 < j && j < i ?
                    pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j)
                        : 1);

            }

            pascalTriangle.add(currRow);
        }

        return pascalTriangle;
    }

    public static List<Integer> generateKthRowPascalTriangle(int rows) {
      List<Integer> kthRow = new ArrayList<>();

      for(int i = 0; i < rows; ++i) {
          if(i == 0 || i == rows - 1) {
              kthRow.add(1);
              continue;
          }

          // (kthrow(i - 1) * (rows - i)) / i
          kthRow.add( (kthRow.get(i - 1) * (rows - i)) / i);
      }
      return kthRow;
    }

    public static void main(String[] args) {
        List<List<Integer>> pascalTriangle = generatePascalTriangle(7);

        for(int i = 0; i < pascalTriangle.size(); ++i) {
            System.out.println(pascalTriangle.get(i));
        }

        System.out.println(generateKthRowPascalTriangle(7));
    }
}

