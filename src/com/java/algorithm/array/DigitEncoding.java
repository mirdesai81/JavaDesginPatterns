package com.java.algorithm.array;

/**
 * Created by mihir.desai on 4/2/2018.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a program which takes as input an array of digits encoding
 * a decimal number D and updates the array to represent the number D + 1.
 * For example, if the input is (1,2,9) then you should update the array to (1,3,0).
 */
public class DigitEncoding {

    public static List<Integer> plusOne(List<Integer> a) {
        int n = a.size() - 1;

        a.set(n,a.get(n) + 1);

        for(int i = n; i > 0 && a.get(i) == 10; --i) {
            a.set(i,0);
            a.set(i - 1,a.get(i - 1) + 1);
        }

        if(a.get(0) == 10) {
            a.set(0, 0);
            a.add(0,1);
        }

        return a;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(9,9,9,9));
        input.stream().forEach(System.out::print);
        System.out.println();
        plusOne(input);
        input.stream().forEach(System.out::print);
    }
}
