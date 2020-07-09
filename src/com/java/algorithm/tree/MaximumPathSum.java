package com.java.algorithm.tree;

public class MaximumPathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };



        private static int maxSum;

        public static int findMaximumPathSum(TreeNode root) {
            // TODO: Write your code here
            maxSum = Integer.MIN_VALUE;
            calculateMaxSum(root);
            return maxSum;
        }

        public static int calculateMaxSum(TreeNode currentNode) {
            if(currentNode == null) return 0;

            int leftMaxSum  = calculateMaxSum(currentNode.left);
            int rightMaxSum = calculateMaxSum(currentNode.right);
            int currentSum = 0;
            leftMaxSum = Math.max(leftMaxSum , 0);
            rightMaxSum = Math.max(rightMaxSum, 0);

            currentSum = leftMaxSum + rightMaxSum + currentNode.val;
            maxSum = Math.max(currentSum,maxSum);

            return Math.max(leftMaxSum,rightMaxSum) + currentNode.val;

        }



        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);
            root.right.left = new TreeNode(5);
            root.right.right = new TreeNode(6);
            root.right.left.left = new TreeNode(7);
            root.right.left.right = new TreeNode(8);
            root.right.right.left = new TreeNode(9);
            System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

            root = new TreeNode(-1);
            root.left = new TreeNode(-3);
            System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
        }


}
