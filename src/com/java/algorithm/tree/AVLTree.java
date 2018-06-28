package com.java.algorithm.tree;

public class AVLTree {


    private BinaryTreeNode<Integer> leftRotate(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }

    private BinaryTreeNode<Integer> rightRotate(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        root.height = setHeight(root);
        root.size = setSize(root);
        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);
        return newRoot;
    }


    public BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
        if(root == null) {
            return new BinaryTreeNode<Integer>(data);
        }

        if(root.data <= data) {
            root.right = insert(root.right,data);
        } else {
            root.left = insert(root.left,data);
        }

        int balance = balance(root.left,root.right);

        if(balance > 1) {
            if(height(root.left.left) >= height(root.left.right)) {
                root = rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        } else if(balance < -1) {
            if(height(root.right.right) >= height(root.right.left)) {
                root = leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        } else {

            root.height = setHeight(root);
            root.size = setSize(root);
        }

        return root;
    }

    private int setSize(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;

        return 1 + Math.max(root.left != null ? root.left.size : 0 ,root.right != null ? root.right.size : 0);
    }


    private int setHeight(BinaryTreeNode<Integer> root) {
        if(root == null) return 0;

        return 1 + Math.max(root.left != null ? root.left.height : 0 ,root.right != null ? root.right.height : 0);
    }

    private int height(BinaryTreeNode<Integer> node) {
        if(node == null) return 0;

        return node.height;
    }

    private int balance(BinaryTreeNode<Integer> left,BinaryTreeNode<Integer> right) {
        return height(left) - height(right);
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        BinaryTreeNode<Integer> root = null;
        root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);
    }
}
