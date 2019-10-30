package com.java.algorithm.array;

import com.java.stdlib.StdOut;

import java.util.*;

/*
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        Map<Integer,Integer> lookup = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length;i++) {
            int diff = target - nums[i];
            if(lookup.containsKey(diff)) {
                result.add(Arrays.asList(lookup.get(diff) , i));
            }
            lookup.put(nums[i],i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,-15,10,-14};
        ArrayUtils.print("Before",nums);
       // int[] result = TwoSum.twoSum(nums,-4);
        StdOut.println("Result of Two Sum" + TwoSum.twoSum(nums,-4));
    }
}
