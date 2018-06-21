package com.java.algorithm.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Leaves {


    public BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root,int data) {
        if(root == null) {
            return new BinaryTreeNode<>(data);
        }

        BinaryTreeNode<Integer> temp = null;
        if(data < root.data) {
            temp = insert(root.left,data);
            root.left = temp;
            temp.parent = root;
        } else {
            temp = insert(root.right,data);
            root.right = temp;
            temp.parent = root;
        }

        return root;
    }


    public static List<BinaryTreeNode<Integer>> findLeaves(BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> leaves = new ArrayList<>();
        findLeavesHelper(tree,leaves);
        return leaves;
    }

    private static void findLeavesHelper(BinaryTreeNode<Integer> tree,List<BinaryTreeNode<Integer>> leaves) {

        if(tree!=null) {

            if(tree.left == null && tree.right == null) {
                leaves.add(tree);
            } else {
                findLeavesHelper(tree.left,leaves);
                findLeavesHelper(tree.right,leaves);
            }
        }
    }

    public static List<BinaryTreeNode<Integer>> findLeavesIterative(BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> leaves = new ArrayList<>();
        BinaryTreeNode<Integer> curr = tree;
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(curr);

        while(!stack.isEmpty()) {
            curr = stack.pop();

            if(curr.right != null) {
                stack.push(curr.right);
            }

            if(curr.left != null) {
                stack.push(curr.left);
            }


            if(curr.left == null && curr.right == null) {
                leaves.add(curr);
            }
        }

        return leaves;
    }


    public static void main(String[] args) {
        Leaves tree = new Leaves();
        BinaryTreeNode<Integer> root = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        root = tree.insert(root,9);
        root = tree.insert(root,13);

        List<BinaryTreeNode<Integer>> leaves = findLeavesIterative(root);

        System.out.println(leaves.stream().map(x->x.data.toString()).collect(Collectors.joining("->")));
    }
}
