package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/9/2018.
 */
public class SnakeString {

    public static String getSnakeString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i = i + 4) {
            sb.append(s.charAt(i));
        }

        for(int i = 0; i < s.length(); i = i + 2) {
            sb.append(s.charAt(i));
        }

        for(int i = 3; i < s.length(); i = i + 4) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSnakeString("Hello World!"));
    }

}
