package com.java.algorithm.array;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckConsecutiveNumbers {

    private static boolean checkConsecutiveNumbers(List<Integer> A) {

        if(A == null || A.isEmpty() || A.size() == 1) {
            return true;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : A) {
            if(i < min) {
                min = i;
            }

            if(i > max) {
                max = i;
            }
        }

        for(int i=0; i < A.size(); i++){
            if(Math.abs(A.get(i)) - min >= A.size()){
                return false;
            }

            int key = Math.abs(A.get(i)) - min;
            int value = A.get(Math.abs(A.get(i)) - min);

            if(A.get(Math.abs(A.get(i)) - min) < 0){
                return false;
            }

            StdOut.println(Math.abs(A.get(i)) - min);

            A.set(Math.abs(A.get(i)) - min,-A.get(Math.abs(A.get(i)) - min));
        }
        for(int i=0; i < A.size() ; i++){
            A.set(i,Math.abs(A.get(i)));
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(3,1,4,5,2));
        System.out.println(checkConsecutiveNumbers(A));
    }
}
