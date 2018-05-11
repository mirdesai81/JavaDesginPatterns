package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/9/2018.
 */
public class RemoveDuplicates {

    public static String removeDuplicates(String s) {
        char[] str = s.toCharArray();
        boolean[] containsCharacter = new boolean[256];
        int writeIndex = 0;
        for(int i = 0; i < str.length;++i) {
            char c = str[i];

            if(!containsCharacter[c]) {
                str[writeIndex] = c;
                writeIndex++;
            }

            containsCharacter[c] = true;
        }

        return new String(str,0,writeIndex);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcabcdefgfg"));
    }
}
