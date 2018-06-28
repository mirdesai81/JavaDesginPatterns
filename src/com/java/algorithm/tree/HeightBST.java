package com.java.algorithm.tree;

import java.util.Stack;

public class HeightBST {


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

    public static int findHeight(BinaryTreeNode<Integer> tree) {
        if(tree==null) {
            return 0;
        }

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(tree);
        int height = 0;

        while(true) {
            int nodeCount = stack.size();
            if(nodeCount == 0) {
                return height;
            }

            height++;

            while(nodeCount > 0) {
                BinaryTreeNode<Integer> newNode = stack.pop();
                if(newNode.right != null) {
                    stack.push(newNode.right);
                }

                if(newNode.left != null) {
                    stack.push(newNode.left);
                }
                nodeCount--;
            }
        }
    }

    public static void main(String[] args) {
        HeightBST tree = new HeightBST();
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

        System.out.println("Height of binary tree - "+findHeight(root));
    }
}
