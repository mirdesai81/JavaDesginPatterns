package com.java.algorithm.educative.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllCombinationOfParentheses {

    static class Parentheses {
        public ArrayList<String> entry;
        public int open;
        public int close;

        public Parentheses(ArrayList<String> list,int open,int close) {
            this.entry = list;
            this.open = open;
            this.close = close;
        }
    }

    public static ArrayList<ArrayList<String>> generateParentheses(int num) {
        ArrayList<ArrayList<String>> result  = new ArrayList<>();
        Queue<Parentheses> queue = new LinkedList<>();
        queue.add(new Parentheses(new ArrayList<>(),0,0));

        while(!queue.isEmpty()) {
            Parentheses parentheses = queue.poll();
            ArrayList<String> entry = new ArrayList<>();
            if(parentheses.open == num && parentheses.close == num) {
                entry = (ArrayList) parentheses.entry.clone();
                result.add(entry);
            }

            if(parentheses.open < num) {
                entry = (ArrayList) parentheses.entry.clone();
                entry.add("{");
                queue.add(new Parentheses(entry,parentheses.open + 1,parentheses.close));
            }

            if(parentheses.open > parentheses.close) {
                entry = (ArrayList) parentheses.entry.clone();
                entry.add("}");
                queue.add(new Parentheses(entry,parentheses.open,parentheses.close + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParentheses(2));
    }
}
