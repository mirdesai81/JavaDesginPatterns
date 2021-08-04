package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindPathWithMaxSum {

    Integer max = Integer.MIN_VALUE;
    Integer sum = 0;

    public class Pair {
        Integer sum;
        Integer max;
        List<TreeNode> path;

        public Pair() {
            this.sum = 0;
            this.max = Integer.MIN_VALUE;
            path = new ArrayList<>();
        }

        public void setMax(int max) {
            this.max = max;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public void setPath(List<TreeNode> path) {
            this.path = path;
        }

    }

    public  Integer findPathWithMaxSum(TreeNode root) {
        Pair pair = new Pair();
        findPathWithMaxSum(root,pair, new ArrayList<>());
        return pair.max;
    }

    public  void findPathWithMaxSum(TreeNode root,Pair pair,List<TreeNode> partialPath) {
        if(root == null) return;

        pair.sum = pair.sum + root.val;
        partialPath.add(root);

        if(pair.sum > pair.max && root.left == null && root.right == null) {
            pair.max = pair.sum;
            pair.setPath(new ArrayList<>(partialPath));
        } else {
            findPathWithMaxSum(root.left,pair,partialPath);
            findPathWithMaxSum(root.right,pair,partialPath);
        }

        pair.sum = pair.sum - root.val;
        partialPath.remove(partialPath.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println("Tree paths with max sum " + new FindPathWithMaxSum().findPathWithMaxSum(root));
    }
}
