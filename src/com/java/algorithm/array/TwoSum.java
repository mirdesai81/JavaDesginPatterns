package com.java.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/*
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> lookup = new HashMap<>();
        for(int i = 0; i < nums.length;i++) {
            int diff = target - nums[i];
            if(lookup.containsKey(diff)) {
                return new int[] {lookup.get(diff) , i};
            }
            lookup.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,-15};
        ArrayUtils.print("Before",nums);
        int[] result = TwoSum.twoSum(nums,-4);
        ArrayUtils.print("Result of Two Sum",result);
    }
}
