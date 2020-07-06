package com.java.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathEqualToSum {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

        public static List<List<Integer>> findPaths(TreeNode root, int sum) {
            List<List<Integer>> allPaths = new ArrayList<>();
            // TODO: Write your code here
            List<Integer> partialPath = new ArrayList<>();
            findPaths(root,sum,partialPath,allPaths);
            return allPaths;
        }

        private static void findPaths(TreeNode root,int sum,List<Integer> partialPath,List<List<Integer>> allPaths) {
            if(root == null) return;

            partialPath.add(root.val);

            if(root.val == sum && root.left == null && root.right == null) {
                allPaths.add(new ArrayList<Integer>(partialPath));
            } else {
                findPaths(root.left,sum - root.val,partialPath,allPaths);
                findPaths(root.right,sum - root.val,partialPath,allPaths);
            }

            partialPath.remove(partialPath.size() - 1);
        }

        public static int findMaxSum(TreeNode root) {
            Integer max = Integer.MIN_VALUE;
            Integer maxSum = findMaxSum(root,max,0);
            return maxSum;
        }

        private static Integer findMaxSum(TreeNode root,Integer max,Integer sum) {
            if(root == null) return Integer.MIN_VALUE;

            sum = sum + root.val;

            if(root.left == null && root.right == null) {
                return Math.max(max,sum);
            } else {
                return Math.max(findMaxSum(root.left,max,sum),findMaxSum(root.right,max,sum));
            }

        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(4);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            int sum = 23;
            List<List<Integer>> result = FindAllPathEqualToSum.findPaths(root, sum);
            System.out.println("Tree paths with sum " + sum + ": " + result);

            root.right.left.right = new TreeNode(11);
            root.right.right.right = new TreeNode(25);
            int max = FindAllPathEqualToSum.findMaxSum(root);
            System.out.println("Max Sum " + max);
        }


}
