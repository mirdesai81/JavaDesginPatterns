package com.java.algorithm.educative.stackAndQueue;

import java.util.HashMap;
import java.util.Map;

public class CheckBalancedParentheses {

    public static boolean isBalanced(String exp) {
        // Write -- Your -- Code
        Stack<Character> stack = new Stack<>(exp.length());
        Map<Character,Character> charMap = new HashMap<>();
        charMap.put('{','}');
        charMap.put('(',')');
        charMap.put('[',']');
        for(int i = 0; i < exp.length(); i++) {
            char input = exp.charAt(i);

            if(charMap.containsKey(input)) {
                System.out.println("Push :"+charMap.get(input));
                stack.push(charMap.get(input));
            } else {
                if(stack.isEmpty()) return false;
                char val = stack.pop();
                System.out.println("Poped:" + input);
                if(!isEqualCharacters(input,val)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isEqualCharacters(char ch1, char ch2) {
        System.out.println(ch1 + " " + ch2);
        return ch1 == ch2;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{}{}{}"));
    }

}
