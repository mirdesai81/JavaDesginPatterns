package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextPlacement {

    public static int minimumMessiness(List<String> words, int lineLength) {
        int[] minimumMessiness = new int[words.size()];
        Arrays.fill(minimumMessiness,Integer.MAX_VALUE);
        int numRemainingBlanks = lineLength - words.get(0).length();
        minimumMessiness[0] = numRemainingBlanks * numRemainingBlanks;

        for(int i = 1; i < words.size(); i++) {
            numRemainingBlanks = lineLength - words.get(i).length();
            minimumMessiness[i] = minimumMessiness[i - 1] + numRemainingBlanks * numRemainingBlanks;

            // try adding words i - 1, i -2 ...
            for(int j = i - 1; j >= 0; j--) {
                numRemainingBlanks = numRemainingBlanks - (words.get(j).length() + 1);
                if(numRemainingBlanks < 0) {
                    break;
                }

                int firstJMessiness = j - 1 < 0  ? 0 : minimumMessiness[j - 1];
                int currentLineMessiness = numRemainingBlanks * numRemainingBlanks;

                minimumMessiness[i] = Math.min(minimumMessiness[i] , firstJMessiness + currentLineMessiness);
            }

        }

        return minimumMessiness[words.size() - 1];
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("aaa","bbb","c","d","ee","ff","ggggggg"));
        StdOut.println(minimumMessiness(words,11));
    }
}
