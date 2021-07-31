package com.java.algorithm.educative.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBalancedParentheses {


    static class Parentheses {
        public String str;
        public int openCount = 0;
        public int closeCount = 0;

        public Parentheses(String s,int openCount, int closeCount) {
            this.str = s;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }

    }


        public static List<String> generateValidParentheses(int num) {
            List<String> result = new ArrayList<String>();
            Queue<Parentheses> queue = new LinkedList<>();
            queue.add(new Parentheses("",0,0));
            // TODO: Write your code here
            while(!queue.isEmpty()) {
                Parentheses p = queue.poll();

                if(p.openCount == num && p.closeCount == num) {
                    result.add(p.str);
                }
                if(p.openCount < num) {
                    queue.add(new Parentheses(p.str + "(", p.openCount + 1,p.closeCount));
                }

                if(p.openCount > p.closeCount) {
                    queue.add(new Parentheses(p.str + ")", p.openCount,p.closeCount + 1));
                }

            }
            return result;
        }

        public static void main(String[] args) {
            List<String> result = GenerateBalancedParentheses.generateValidParentheses(2);
            System.out.println("All combinations of balanced parentheses are: " + result);

            result = GenerateBalancedParentheses.generateValidParentheses(3);
            System.out.println("All combinations of balanced parentheses are: " + result);
        }


}
