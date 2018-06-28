package com.java.algorithm.tree;

public class SuccessorNode {

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

    public static BinaryTreeNode<Integer> inOrderSuccessor(BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> curr = node;
        if(curr.right != null) {
            // find left most element in right subtree
            curr = curr.right;
            while(curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        while(curr.parent != null && curr.parent.right == curr) {
            curr = curr.parent;
        }

        return curr.parent;
    }

    public static BinaryTreeNode<Integer> inOrderSuccessor(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> curr = node;
        if(curr.right != null) {
            // find left most element in right subtree
            curr = curr.right;
            while(curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        BinaryTreeNode<Integer> successor = null;
        while(root != null) {
            int cmp = node.data.compareTo(root.data);
            if(cmp < 0) {
                successor = root;
                root = root.left;
            } else if(cmp > 0) {
                root = root.right;
            } else {
                break;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        SuccessorNode tree = new SuccessorNode();
        BinaryTreeNode<Integer> root = null,temp = null,successor=null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        root = tree.insert(root,9);
        root = tree.insert(root,13);
        temp = root.left;
        successor = tree.inOrderSuccessor(temp);
        System.out.println( successor  != null ? successor.data : null);

        temp = root.left.right.right;
        successor = tree.inOrderSuccessor(root,temp);
        System.out.println( successor  != null ? successor.data : null);
    }

}
