package com.java.algorithm.tree;

public class SumOfAllPaths {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };
        public static int findSumOfPathNumbers(TreeNode root) {
            // TODO: Write your code here
            int pathSum = 0;
            pathSum = findSumOfPathNumbers(root,pathSum);
            return pathSum;
        }

        public static int findSumOfPathNumbers(TreeNode root,int pathSum) {
            if(root == null) return 0;

            pathSum = pathSum * 10 + root.val;

            if(root.left == null && root.right == null) {
                return pathSum;
            }

            return findSumOfPathNumbers(root.left,pathSum) + findSumOfPathNumbers(root.right,pathSum);
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(0);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(1);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(5);
            System.out.println("Total Sum of Path Numbers: " + SumOfAllPaths.findSumOfPathNumbers(root));
        }

}
