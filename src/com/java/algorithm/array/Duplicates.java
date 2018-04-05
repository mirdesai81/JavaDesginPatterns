package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mihir.desai on 4/4/2018.
 */
public class Duplicates {
    public static int deleteDuplicates(List<Integer> input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }
        System.out.println("Before Duplicates removed "+input);
        int writeIndex = 1;
        for(int i = 1; i < input.size(); ++i) {
            if(!input.get(writeIndex - 1).equals(input.get(i))) {
                input.set(writeIndex++,input.get(i));
                /*System.out.println("Duplicates overwrite "+input);*/
            }
        }
        System.out.println("After Duplicates removed "+input.subList(0,writeIndex));
        return writeIndex;
    }

    public static int deleteElement(List<Integer> input,int key) {
        if(input == null || input.isEmpty()) {
            return 0;
        }
        System.out.println("Before removed "+input);
        int writeIndex = 0;
        for(int i = 0; i < input.size(); ++i) {
            if(input.get(i) != key) {
                input.set(writeIndex++,input.get(i));
                /*System.out.println("Duplicates overwrite "+input);*/
            }
        }
        System.out.println("After removed "+input.subList(0,writeIndex));
        return writeIndex;
    }

    public static int limitDuplicatesInSortedArray(List<Integer> input,int m) {
        int min = Math.min(2,m);
        int writeIndex = min;
        int duplicateCount = 1;
        System.out.println("Before removed "+input);
        for(int i = min; i < input.size(); ++i) {
            if(!input.get(writeIndex - 1).equals(input.get(i))) {
                duplicateCount = 1;
                input.set(writeIndex++,input.get(i));
            } else {
                if(duplicateCount < min) {
                    input.set(writeIndex++,input.get(i));
                    ++duplicateCount;
                }
            }
        }
        System.out.println("After removed "+input.subList(0,writeIndex));
        return writeIndex;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(2,3,5,5,7,11,11,11,13));
        System.out.println(deleteDuplicates(input));

       /* input = new ArrayList<>(Arrays.asList(2,3,5,5,7,11,11,11,13));
        System.out.println(deleteElement(input,5));

        input = new ArrayList<>(Arrays.asList(12,13,7,5,7,11,5,11,5));
        System.out.println(deleteElement(input,5));

        input = new ArrayList<>(Arrays.asList(2,3,7,7,11,11,13));
        System.out.println(deleteElement(input,5));
*/
        input = new ArrayList<>(Arrays.asList(2,3,5,5,5,7,11,11,11,13));
        System.out.println(limitDuplicatesInSortedArray(input,1));

    }
}
