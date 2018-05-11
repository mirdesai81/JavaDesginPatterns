package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/9/2018.
 */
public class WordCount {
    public static int countWords(String s) {
        boolean isPrevCharacter = false;
        int count = 0;
        for(int i = 0; i < s.length();++i) {
            boolean isCharacter = Character.isLetter(s.charAt(i));

            if(!isPrevCharacter && isCharacter) {
                ++count;
            }

            isPrevCharacter = isCharacter;
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(countWords("A man is in great danger!"));
    }
}
