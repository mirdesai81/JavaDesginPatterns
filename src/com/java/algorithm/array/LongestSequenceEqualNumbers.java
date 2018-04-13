package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mihir.desai on 4/5/2018.
 */
public class LongestSequenceEqualNumbers {

    public static int longestSequence(List<Integer> input) {
        int count = 1;
        int max = 1;
        int start = 0;
        int end = 0;
        int temp = 0;

        for(int i = 1; i < input.size(); ++i){
            if(input.get(i) == input.get(i - 1)) {
                count++;
            } else {
                if(count > max) {
                    max = count;
                    end = i - 1;
                    start = temp;
                }
                count = 1;
                temp = i;
            }
        }

        if(count > max) {
            start = temp;
            end = input.size() - 1;
            max = count;
        }
        System.out.println("Start = "+start+" ,End = "+end+" ,Max = "+max);
        return max;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(2,3,5,5,7,11,11,11,11,13));
        System.out.println(longestSequence(input));
    }
}
