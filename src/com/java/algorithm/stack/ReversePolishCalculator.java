package com.java.algorithm.stack;

public class ReversePolishCalculator {

    public static Integer RPN(String expression) {
        Integer result = null;
        String[] tokens = expression.split(",");
        String operator = "+-*/";
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>(10);
        for(String token : tokens) {
            if(token.length() == 1 && operator.contains(token)) {

                switch (operator.indexOf(token)) {
                    case 0:
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case 1:
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case 2:
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case 3:
                        stack.push(stack.pop() / stack.pop());
                        break;
                    default:
                        throw new IllegalArgumentException("malformed RPN at token -"+token);
                }

            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    public static Integer PN(String expression) {
        Integer result = null;
        String[] tokens = expression.split(",");
        String operator = "+-*/";
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>(10);
        for(int i = tokens.length - 1; i >= 0; i--) {
            if(tokens[i].length() == 1 && operator.contains(tokens[i])) {

                switch (operator.indexOf(tokens[i])) {
                    case 0:
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case 1:
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case 2:
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case 3:
                        stack.push(stack.pop() / stack.pop());
                        break;
                    default:
                        throw new IllegalArgumentException("malformed RPN at token -"+tokens[i]);
                }



            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("Result for RPN(2,1,+,3,+) "+RPN("2,1,+,3,*"));
        System.out.println("Result for PN(+,9,*,2,6) "+PN("+,9,*,2,6"));
    }
}
