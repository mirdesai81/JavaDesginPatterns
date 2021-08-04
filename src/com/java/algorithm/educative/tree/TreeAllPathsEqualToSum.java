package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeAllPathsEqualToSum {


        public static List<List<Integer>> findPaths(TreeNode root, int sum) {
            List<List<Integer>> allPaths = new ArrayList<>();
            // TODO: Write your code here
            List<Integer> partialPath = new ArrayList<>();
            findPaths(root,sum,partialPath,allPaths);
            return allPaths;
        }

        public static void findPaths(TreeNode root,int sum,List<Integer> partialPath,List<List<Integer>> allPaths) {
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

        public static void main(String[] args) {
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(4);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            int sum = 23;
            List<List<Integer>> result = findPaths(root, sum);
            System.out.println("Tree paths with sum " + sum + ": " + result);
        }

}
