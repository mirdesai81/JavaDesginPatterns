package com.java.algorithm.search;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int mid = 0;

        while(low <= high) {
            mid = low + (high - low)/2;
            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] == target) {
                return mid;
            } else {
                high = mid - 1;
            }
        }

        return target <= nums[mid] ? mid : mid + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,4,6};
        System.out.println(searchInsert(nums,2));
        System.out.println(searchInsert(nums,5));
    }
}
