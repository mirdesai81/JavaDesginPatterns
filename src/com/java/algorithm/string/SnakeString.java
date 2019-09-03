package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/9/2018.
 */
public class SnakeString {

    private static String getSnakeString(String s) {
        StringBuilder result = new StringBuilder();

        for(int i = 1; i < s.length();i += 4) {
            result.append(s.charAt(i));
        }

        for(int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }

        for(int i = 3; i < s.length(); i+= 4) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSnakeString("Hello World!"));
    }

}
