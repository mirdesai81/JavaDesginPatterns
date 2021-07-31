package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class CheckBST {

    public static Boolean isBST(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stk = new Stack<>();
        BinaryTreeNode prev = null;
        BinaryTreeNode curr = null;
        while(!stk.isEmpty() || root != null) {
            if(root != null) {
                stk.push(root);
                root = root.left;
            } else {
                curr = stk.pop();
                if(prev != null && prev.data >= curr.data) {
                    return false;
                }
                prev = curr;
                if(curr.right != null) stk.push(curr.right);
            }
        }
        return true;
    }

    public static void main(String[] argv) {
        BinaryTreeNode root = new BinaryTreeNode(100);
        BinaryTree.insert(root, 50);
        BinaryTree.insert(root, 200);
        BinaryTree.insert(root, 25);
        // Add a node at an incorrect position
        root.left.right = new BinaryTreeNode(125);
        //BinaryTree.insertInorderBinaryTree(root, 125);
        BinaryTree.insert(root, 150);
        BinaryTree.insert(root, 300);

        BinaryTree.display_inorder(root);
        System.out.println();
        System.out.println(Boolean.toString(isBST(root)));
    }

}
