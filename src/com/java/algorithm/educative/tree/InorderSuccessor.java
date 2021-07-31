package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {


        static BinaryTreeNode findMinInTree(
                BinaryTreeNode root) {

            if(root == null)
                return null;

            while(root.left != null) {
                root = root.left;
            }

            return root;
        }

    static BinaryTreeNode inorderSuccessorBST(BinaryTreeNode root, int d) {
        // TODO: Write - Your - Code
        if(root == null) return null;
        BinaryTreeNode successor = null;
        while(root != null) {
            // if root data is greater than successor should be in left sub tree
            if(root.data > d) {
                System.out.println("left Move "+root.data+" "+d);
                successor = root;
                root = root.left;
            } else if(root.data < d) {
                System.out.println("right Move "+root.data+" "+d);
                root = root.right;
            } else { // when d is found
                System.out.println("Found "+root.data+" "+d);
                if(root.right != null) {
                    System.out.println(root.right.data);
                    return findMinInTree(root.right);
                }
                return successor;
            }
        }
        return successor;
    }
        /// Test Program.
        public static void main(String[] args) {

            List<Integer> input = new ArrayList<Integer>();
            input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(350);
            BinaryTreeNode root = BinaryTree.create_BST(input);

            BinaryTree.populate_parents(root);

            for (Integer d : input) {
                BinaryTreeNode successor = inorderSuccessorBST(root, d);
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
