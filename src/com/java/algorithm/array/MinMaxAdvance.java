package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mihir.desai on 4/4/2018.
 */
public class MinMaxAdvance {

    public static boolean maxCanReachEnd(List<Integer> input) {
        if(input.size() <= 1) {
            return false;
        }

        if(input.get(0) == 0) {
            return false;
        }

        System.out.println("Input - "+input);
        int maxReachSoFar = input.get(0);
        int lastIndex = input.size() - 1;



        for(int i = 1; i <= maxReachSoFar && maxReachSoFar < lastIndex; ++i) {
            maxReachSoFar = Math.max(maxReachSoFar, i + input.get(i));
            System.out.println(" i = "+i+" ,maxReach = "+maxReachSoFar);
        }

        return maxReachSoFar >= lastIndex;
    }

    public static int minJumps(List<Integer> input)  {
        if(input.size() <= 1) {
            return 0;
        }

        if(input.get(0) == 0) {
            return -1;
        }

        System.out.println("Input - "+input);
        int maxReachSoFar = input.get(0);
        int lastIndex = input.size() - 1;
        int step = input.get(0);
        int jump = 1;

        System.out.println(" i = 0 ,maxReach = "+maxReachSoFar+" , step = "+step);
        for(int i = 1; i <= maxReachSoFar && maxReachSoFar < lastIndex; ++i) {
            maxReachSoFar = Math.max(maxReachSoFar, i + input.get(i));
            step--;
            System.out.println(" i = "+i+" ,maxReach = "+maxReachSoFar+" , step = "+step);
            if(step == 0) {
                jump++;

                step = maxReachSoFar - i;
                System.out.println("jumps = "+jump+ ", step = "+step);
            }
        }

        if(maxReachSoFar >= lastIndex) {
            return jump;
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(3,3,1,0,2,0,1));
        System.out.println(maxCanReachEnd(input));

        input = new ArrayList<>(Arrays.asList(2,4,1,1,0,2,3));
        System.out.println(maxCanReachEnd(input));

        System.out.println(minJumps(input));
    }
}
