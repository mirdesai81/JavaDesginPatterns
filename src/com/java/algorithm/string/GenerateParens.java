package com.java.algorithm.string;

import com.java.stdlib.StdOut;

import java.util.HashSet;
import java.util.Set;

public class GenerateParens {


    public static Set<String> generateParen(int remaining) {
        Set<String> set = new HashSet<>();
        if(remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParen(remaining - 1);
            for(String str : prev) {
                for(int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == '(') {
                        set.add(insertInside(str,i));
                    }
                }

                set.add("()" + str);
            }
        }

        return set;
    }

    private static String insertInside(String str,int i) {
        String start = str.substring(0,i + 1);
        String end = str.substring(i + 1);
        return start + "()" + end;
    }

    public static void main(String[] args) {
        StdOut.println(generateParen(3));
    }
}
