package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

public class CheckTreeAsBST {
    public static Integer last_value;

    public static boolean  checkBST(BinaryTreeNode<Integer> tree) {
        if(tree == null) return true;

        if(!checkBST(tree.left)) return false;

        if(last_value != null && tree.data <= last_value) return false;

        last_value = tree.data;

        if(!checkBST(tree.right)) return false;

        return true;
    }


    public static boolean checkBST(BinaryTreeNode<Integer> tree, Integer min, Integer max) {
        if(tree == null) return true;

        if((min != null && tree.data <= min) || (max != null && tree.data > max)) {
            return false;
        }

        if(!checkBST(tree.left,min,tree.data) || !checkBST(tree.right,tree.data,max)) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(20);

        tree.left = new BinaryTreeNode<>(10);
        tree.left.right = new BinaryTreeNode<>(25);
        tree.left.left = new BinaryTreeNode<>(5);

        tree.right = new BinaryTreeNode<>(30);
        tree.right.right = new BinaryTreeNode<>(35);
        tree.right.left = new BinaryTreeNode<>(25);

        StdOut.println(checkBST(tree));

        StdOut.println(checkBST(tree,null,null));
    }
}
