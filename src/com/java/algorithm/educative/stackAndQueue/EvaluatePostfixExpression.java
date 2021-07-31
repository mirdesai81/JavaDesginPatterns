package com.java.algorithm.educative.stackAndQueue;

class EvaluatePostfixExpression {
    public static int evaluatePostFix(String expression) {
        int len = expression.length();
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>(len);
        while(i < len) {
            char ch = expression.charAt(i);
            if(!Character.isDigit(ch)) {
                int  v1 = stack.pop();
                int v2 = stack.pop();
                System.out.println(v1 + " " + v2);
                int value = getValue(ch,v1,v2);
                stack.push(value);
            } else {
                stack.push(Character.getNumericValue(ch));
            }
            i++;
        }

        return stack.pop();
    }

    public static int getValue(char ch,int v1,int v2) {
        switch(ch) {
            case '*' : return v2 * v1;
            case '+' : return v2 + v1;
            case '-' : return v2 - v1;
            case '/' : return v2/v1;
        }

        return 0;
    }

    public static void main(String args[]) {

        System.out.println(evaluatePostFix("921*-8-4+"));
        //Try your own examples below

    }
}
