package com.java.algorithm.string;

import java.util.Arrays;

/**
 * Created by Mihir.Desai on 5/9/2018.
 */
public class ReplaceSpace {
    public static String replaceSpace(String s, String t) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') {
                count++;
            }
        }

        int len = (n - count) + count*3;
        StringBuilder result = new StringBuilder(len);

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != ' ') {
                result.append(s.charAt(i));
            } else {
                result.append(t);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("I am a super hero","%100"));
    }
}
