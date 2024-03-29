package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.TreeNode;

class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        // TODO: Write your code here
        return findPath(root,sequence,0);
    }

    public static boolean findPath(TreeNode root,int[] sequence, int level) {
        if(root == null) return false;

        if(level < sequence.length && root.val == sequence[level] && root.left == null && root.right == null) {
            return true;
        } else {
            return findPath(root.left,sequence, level + 1) || findPath(root.right,sequence, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
