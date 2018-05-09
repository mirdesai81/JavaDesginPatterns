package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihir.Desai on 4/30/2018.
 */
public class PascalTriangle {

    public static List<List<Integer>> generatePascalTriangle(int rows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for(int i = 0; i < rows; ++i) {
            List<Integer> currRow = new ArrayList<>();
            for(int j = 0; j <= i; ++j) {
                currRow.add((j == 0 || j == i)? 1 : pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
            }

            pascalTriangle.add(currRow);
        }

        return pascalTriangle;
    }

    public static List<Integer> generateKthRowPascalTriangle(int rows) {
        List<Integer> kthRow = new ArrayList<>();
        int curr = 1;
        int num = rows;
        int den = 0;
        for(int i = 0 ; i < rows; ++i) {
            if(i == 0 || i == rows - 1) {
                kthRow.add(1);
                /*num = num - 1;
                den = den + 1;*/
                continue;
            }

            kthRow.add(((kthRow.get(i - 1) * (rows - i) ) / i));
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

