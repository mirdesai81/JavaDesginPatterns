package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CountAnyPathsEqualToSum {

    public static int countPaths(TreeNode root,int sum) {
        return countPaths(root,sum,new ArrayList<>());
    }

    public static int countPaths(TreeNode root, int sum,  List<Integer> currentPath) {
        if(root == null) return 0;
        currentPath.add(root.val);

        int pathSum = 0;
        int pathCount = 0;
        ListIterator<Integer> iter = currentPath.listIterator(currentPath.size());
        while(iter.hasPrevious()) {
            pathSum += iter.previous();

            if(pathSum == sum) {
                ++pathCount;
            }
        }

        pathCount += countPaths(root.left,sum,currentPath);
        pathCount += countPaths(root.right,sum,currentPath);
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
