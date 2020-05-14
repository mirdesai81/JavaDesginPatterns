package com.java.algorithm.string;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
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

    public static ArrayList<String> generateParenEfficient(int count) {
        char[] str = new char[count*2];
        ArrayList<String> result = new ArrayList<>();
        addParen(result,count,count,str,0);
        return result;
    }

    private static void addParen(ArrayList<String> list,int leftRem,int rightRem,char[] str,int index) {
        if(leftRem < 0 || rightRem < leftRem) return;

        if(leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParen(list,leftRem - 1,rightRem,str,index + 1);

            str[index] = ')';
            addParen(list,leftRem,rightRem - 1,str,index + 1);
        }
    }

    public static void main(String[] args) {
        StdOut.println(generateParen(3));
        StdOut.println(generateParenEfficient(3));
    }
}
