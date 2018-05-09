package com.java.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mihir.Desai on 5/8/2018.
 */
public class RomanNumber {

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

    public static void main(String[] args) {
        System.out.println(RomanToInteger("LIX"));
    }
}
