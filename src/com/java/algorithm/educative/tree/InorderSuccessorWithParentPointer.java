package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessorWithParentPointer {

    static BinaryTreeNode findMinInTree(BinaryTreeNode root) {
        if(root == null) return null;

        while(root.left != null) {
            root = root.left;
        }

        return root;
    }
    static BinaryTreeNode inOrderSuccessorWithParent(BinaryTreeNode root) {
        if(root == null) return null;

        if(root.right != null) {
            return findMinInTree(root.right);
        }

        while(root.parent != null) {
            if(root.parent.left == root) {
                return root.parent;
            }
            root = root.parent;
        }

        return null;
    }

    static BinaryTreeNode findSuccessor(
            BinaryTreeNode root, int d) {
        // TODO: Write - Your - Code
        if(root == null) return null;

        while(root != null) {
            if(root.data > d) {
                root = root.left;
            } else if(root.data < d) {
                root= root.right;
            } else {
                return inOrderSuccessorWithParent(root);
            }
        }
        return null;
    }

    /// Test Program.
    public static void main(String[] args) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(350);
        BinaryTreeNode root = BinaryTree.create_BST(input);

        BinaryTree.populate_parents(root);

        for (Integer d : input) {
            BinaryTreeNode successor = findSuccessor(root, d);
            int i = input.indexOf(d);
            Integer expected_val = null;
            if (i < input.size() - 1) {
                expected_val = input.get(i + 1);
            }
            if (successor != null)
                System.out.print("(" + d + ", " + successor.data + ") ");
            else
                System.out.print("(" + d + ", null) ");
        }
    }
}
