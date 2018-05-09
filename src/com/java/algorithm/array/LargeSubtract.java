package com.java.algorithm.array;

import java.util.Random;

/**
 * Created by mihir.desai on 4/13/2018.
 */
public class LargeSubtract {

    public static boolean isSmaller(char[] num1, char[] num2) {

        if(num1.length > num2.length) {
            return false;
        }

        if(num1.length < num2.length) {
            return true;
        }

        for(int i = 0; i < num1.length; ++i) {
            if(num1[i] > num2[i]) {
                return false;
            }

            if(num1[i] < num2[i]) {
                return true;
            }
        }

        return false;
    }

    public static void swap(char[] num1,char[] num2) {
        char[] temp;
        temp = num1;
        num1 = num2;
        num2 = temp;
    }

    public static char[] largeSubtract(char[] num1, char[] num2,boolean[] isNegative) {
        isNegative[0] = false;
        char[] temp;
        if(isSmaller(num1,num2)) {
            temp = num1;
            num1 = num2;
            num2 = temp;
            isNegative[0] = true;
        }

        char[] result = new char[num1.length];
        int i = num1.length - 1;
        int j = num2.length - 1;
        int borrow = 0;
        int difference = 0;

        while(j >= 0) {
            difference = num1[i] - num2[j] - borrow;

            if(difference < 0) {
                difference = difference + 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result[i] = (char)difference;
            i--;
            j--;
        }

        while(i >= 0) {
            difference = num1[i] - borrow;
            if(difference < 0) {
                difference = difference + 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result[i] = (char)difference;
            i--;
        }

        return result;
    }

    public static void printArray(char[] a) {
        for (char curVal : a) {
            System.out.print((int)curVal + "");
        }
    }

    public static char[] getRandomNum() {
        Random randomGenerator = new Random();
        int numDigits = 1 + randomGenerator.nextInt(4);
        char[] result = new char[numDigits];

        for (int i = 0; i < numDigits; ++i) {
            if (i == 0)
                /*Most significant digit should be non-zero*/
                result[i] = (char) (1 + randomGenerator.nextInt(9));
            else
                result[i] = (char)randomGenerator.nextInt(10);
        }
        return result;
    }



    public static int convertArrayToNum(char[] a) {
        int num = 0;
        for (char curVal : a) {
            num = (num * 10) + curVal;
        }

        return num;
    }

    public static void printResult(char[] num1, char[] num2,  char[] result, boolean isNegative) {
        printArray(num1);
        System.out.print(" - ");
        printArray(num2);
        System.out.print (" = ");
        if (isNegative)
            System.out.print(" -");

        printArray(result);
        System.out.println("");
    }

    public static void main(String[] args) {
        char[] num1 = getRandomNum();
        char[] num2 = getRandomNum();
        boolean[] isNegative = new boolean[]{false};
        printArray(num1);
        System.out.print(" - ");
        printArray(num2);
        System.out.print (" = ? ");
        System.out.println("");
        char[] result = largeSubtract(num1,num2,isNegative);
        printResult(num1,num2,result,isNegative[0]);
    }
}
