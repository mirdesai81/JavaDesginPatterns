package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class MaxAverageNAryTree {

    public static class TreeNode {
        int val;
        List<TreeNode> children;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val,List<TreeNode> children) {
            this.val = val;
            this.children = children;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public void setChildren(List<TreeNode> children) {
            this.children = children;
        }
    }

    TreeNode result = null;
    double maxAverage = Integer.MIN_VALUE;

    public int[] findMaxAverageHelper(TreeNode root) {
        if(root == null) return new int[] {0,0};

        int value = root.val;
        int count = 1;

        if(root.getChildren() != null && !root.getChildren().isEmpty()) {
            for (TreeNode node : root.children) {
                int arr[] = findMaxAverageHelper(node);
                value = value + arr[0];
                count = count + arr[1];
            }
        }

        double currAverage = value / (0.0 + count);
        if(count > 1 && (result == null || currAverage > maxAverage)) {
            result = root;
            maxAverage = currAverage;
        }

        return new int[] {value , count};
    }

    public TreeNode findMaxAverage(TreeNode root){
        if(root == null) return result;
        findMaxAverageHelper(root);
        return result;
    }

    public static void main(String[] args) {
        /*

             20
	   /   \
	 12     18
  /  |  \   / \
11   2   3 15  8

         */

        TreeNode root = new TreeNode(20);

        TreeNode left = new TreeNode(12);
        List<TreeNode> leftChilds = new ArrayList<>();
        leftChilds.add(new TreeNode(11));
        leftChilds.add(new TreeNode(2));
        leftChilds.add(new TreeNode(3));
        left.setChildren(leftChilds);

        TreeNode right = new TreeNode(18);
        List<TreeNode> rightChilds = new ArrayList<>();
        rightChilds.add(new TreeNode(15));
        rightChilds.add(new TreeNode(8));

        right.setChildren(rightChilds);


        List<TreeNode> children = new ArrayList<>();
        children.add(left);
        children.add(right);

        root.setChildren(children);

        MaxAverageNAryTree avg = new MaxAverageNAryTree();
        avg.findMaxAverage(root);

        StdOut.println(avg.result.val);
        StdOut.println(avg.maxAverage);

    }
}
