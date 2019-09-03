package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mihir.desai on 4/2/2018.
 */
public class MultiplyLargeNumber {

    public static List<Integer> multiply(List<Integer> num1,List<Integer> num2) {
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(),0));

        for(int i = num1.size() - 1; i >= 0; --i) {


            for(int j = num2.size() - 1; j >= 0; --j) {
                System.out.println("Size :"+(i + j + 1)+" ,num1 "+num1.get(i)+" ,num2 "+num2.get(j));
                result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
                System.out.println("Size :"+(i + j + 1)+" ,result "+result.get(i + j + 1));
                result.set(i + j,result.get(i + j) + (result.get(i + j + 1) / 10));
                System.out.println("Size :"+(i + j)+" ,result "+result.get(i + j));
                result.set(i + j + 1,result.get(i + j + 1) % 10);
                System.out.println("Size :"+(i + j + 1)+" ,result "+result.get(i + j + 1));

            }
        }

        // Remove the leading zeroes.
        int first_not_zero = 0;
        while (first_not_zero < result.size () && result.get(first_not_zero) == 0) {
            ++first_not_zero ;
        }
        System.out.println("First non zero is at - "+first_not_zero);
        result = result.subList(first_not_zero,result.size()) ;
        if (result.isEmpty () ) {
            return Arrays.asList(0) ;
        }

        result.set(0 , result.get(0) * sign);

        return result;
    }

    public static void main(String[] args) {
      //  List<Integer> num1 = new ArrayList<>(Arrays.asList(1,9,3,7,0,7,7,2,1));
      //  List<Integer> num2 = new ArrayList<>(Arrays.asList(-7,6,1,8,3,8,2,5,7,2,8,7));

        List<Integer> num1 = new ArrayList<>(Arrays.asList(1,1,2));
        List<Integer> num2 = new ArrayList<>(Arrays.asList(1,1));
        System.out.println(num1);
        System.out.println(num2);
        System.out.println("calling multiply()...");
        List<Integer> result = multiply(num1,num2);
        System.out.println(result);
    }
}
