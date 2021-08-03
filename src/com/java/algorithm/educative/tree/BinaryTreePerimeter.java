package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePerimeter {
    public static String displayTreePerimeter(BinaryTreeNode root) {
        // TODO: Write - Your - Code
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append(root.data).append(" ");
        leftTreePerimeter(root.left,sb);

        if(root.left != null || root.right != null) {
            leafNodes(root,sb);
        }

        rightTreePerimeter(root.right,sb);

        return sb.toString();
    }

    public static void leftTreePerimeter(BinaryTreeNode root,StringBuilder sb) {
        while(root != null) {
            String curr_val = String.valueOf(root.data);
            if(root.left != null) {
                root = root.left;
            } else if(root.right != null) {
                root=root.right;
            } else {
                break;
            }

            sb.append(curr_val).append(" ");
        }
    }

    public static void rightTreePerimeter(BinaryTreeNode root,StringBuilder sb) {

        Stack<String> stk = new Stack<>();
        while(root != null) {
            String curr_val = String.valueOf(root.data);
            if(root.left != null) {
                root = root.left;
            } else if(root.right != null) {
                root=root.right;
            } else {
                break;
            }

            stk.push(curr_val);
        }

        while(!stk.isEmpty()) {
            sb.append(stk.pop()).append(" ");
        }
    }

    public static void leafNodes(BinaryTreeNode root, StringBuilder sb) {
        if(root != null) {
            leafNodes(root.left,sb);
            leafNodes(root.right,sb);

            if(root.left == null && root.right == null) {
                sb.append(root.data).append(" ");
            }
        }
    }

    public static void main(String[] argv) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(100);
        arr.add(50);
        arr.add(200);
        arr.add(25);
        arr.add(60);
        arr.add(350);
        arr.add(10);
        arr.add(70);
        arr.add(400);


        BinaryTreeNode root = BinaryTree.create_BST(arr);
        BinaryTree.display_level_order(root);
        BinaryTree.another_display_tree(root);
        System.out.print("Perimeter:\n");
        System.out.println(displayTreePerimeter(root));
    }

}
