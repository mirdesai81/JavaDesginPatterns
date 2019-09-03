package com.java.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mihir.Desai on 5/8/2018.
 */
public class RomanNumber {

    private static final String[] numerals = new String[]{"M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I"};

    private static final int[] values = new int[]{1000 , 900 , 500, 400, 100, 90, 50, 40, 10, 9, 5, 4 , 1};

    public static int RomanToInteger(String s) {
        Map<Character,Integer> T = new HashMap<Character, Integer>() {
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
            }
        };

        int sum = T.get(s.charAt(s.length() - 1));

        for(int i = s.length() - 2; i >= 0; --i) {
            if(T.get(s.charAt(i)) < T.get(s.charAt(i + 1))) {
                sum = sum - T.get(s.charAt(i));
            } else {
                sum = sum + T.get(s.charAt(i));
            }
        }

        return sum;
    }

    public static String IntegerToRoman(int value) {
        if(value > 3999 || value < 1) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(value > 0) {
            if(value - values[i] >= 0) {
                sb.append(numerals[i]);
                value -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(RomanToInteger("LIX"));
        System.out.println(IntegerToRoman(1994));
    }
}
