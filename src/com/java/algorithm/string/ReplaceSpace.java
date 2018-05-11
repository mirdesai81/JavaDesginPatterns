package com.java.algorithm.string;

import java.util.Arrays;

/**
 * Created by Mihir.Desai on 5/9/2018.
 */
public class ReplaceSpace {
    public static String replaceSpace(String s, String t) {
        int num = 0;
        for(int i = 0 ; i < s.length(); ++i) {
            if(s.charAt(i) == ' ') {
                num++;
            }
        }

        int oldLength = s.length();
        int newLength = oldLength + ((t.length() - 1) * num);
        char[] strArray = Arrays.copyOf(s.toCharArray(),newLength);

        int writeIndex = newLength - 1;
        int i = oldLength - 1;

        while(i >= 0) {
            if(strArray[i] == ' ') {
                for(int j = t.length() - 1; j >= 0; j--) {
                    strArray[writeIndex--] = t.charAt(j);
                }
            } else {
                strArray[writeIndex--] = strArray[i];
            }
            --i;
        }

        return new String(strArray,0,newLength);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("I am a super hero","%100"));
    }
}
