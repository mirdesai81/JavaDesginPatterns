package com.java.algorithm.tree;

public class RightSibling {

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

    public void connect(BinaryTreeNode<Integer> root) {
        root.next = null;
        connectRecursive(root);
    }

    private void connectRecursive(BinaryTreeNode<Integer> node) {

        if(node == null) {
            return;
        }

        if(node.left != null) {
            node.left.next = node.right;
        }

        if(node.right != null) {
            node.right.next = node.next != null ? node.next.left : null;
        }

        connectRecursive(node.left);
        connectRecursive(node.right);
    }

    public static void main(String[] args) {
        RightSibling tree = new RightSibling();
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

        BinaryTreeNode<Integer> node = root;
        tree.connect(node);
        System.out.println(root.toString());
    }
}
