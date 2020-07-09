package com.java.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountPathsForSum {



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

        public static int countPaths(TreeNode root, int S) {
            // TODO: Write your code here
            List<Integer> currentPath = new LinkedList<>();

            return countPaths(root,S,currentPath);

        }

        public static int countPaths(TreeNode currentNode, int S, List<Integer> currentPath) {
            // base case
            if(currentNode == null) return 0;

            currentPath.add(currentNode.val);

            int pathSum = 0;
            int pathCount = 0;

            ListIterator<Integer> iter = currentPath.listIterator(currentPath.size());
            while(iter.hasPrevious()) {
                Integer value = iter.previous();
                pathSum += value;

                if(pathSum == S) {

                    pathCount++;
                }

            }

            pathCount += countPaths(currentNode.left,S,currentPath);

            pathCount += countPaths(currentNode.right,S,currentPath);

            currentPath.remove(currentPath.size() - 1);

            return pathCount;

        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(4);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            System.out.println("Tree has path: " + countPaths(root, 11));
        }


}
