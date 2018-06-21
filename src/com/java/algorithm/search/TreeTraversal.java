package com.java.algorithm.search;

import java.util.*;
import java.util.stream.Collectors;

public class TreeTraversal {

    public static List<Integer> inOrderTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> curr = root;
        while(!stack.empty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.data);
                curr = curr.right;
            }
        }

        return result;

    }

    public static List<Integer> preOrderTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> curr = root;
        stack.push(curr);

        while(!stack.empty()) {
            curr = stack.pop();
            result.add(curr.data);
            if(curr.right != null) {
                stack.push(curr.right);
            }

            if(curr.left != null) {
                stack.push(curr.left);
            }
        }


        return result;
    }

    public static List<Integer> postOrderTraversal(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> curr = root;
        Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
        s1.push(curr);

        while(!s1.empty()) {
            curr = s1.pop();
            s2.push(curr);
            if(curr.left != null) {
                s1.push(curr.left);
            }

            if(curr.right != null) {
                s1.push(curr.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!s2.isEmpty()) {
            result.add(s2.pop().data);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);

        // left subtree
        root.left = new BinaryTreeNode<>(6);
        root.left.left = new BinaryTreeNode<>(271);
        root.left.left.left = new BinaryTreeNode<>(28);
        root.left.left.right = new BinaryTreeNode<>(0);

        root.left.right = new BinaryTreeNode<>(561);
        root.left.right.right = new BinaryTreeNode<>(3);
        root.left.right.right.left = new BinaryTreeNode<>(17);

        //right subtree
        root.right = new BinaryTreeNode<>(6);
        root.right.left = new BinaryTreeNode<>(2);
        root.right.left.right = new BinaryTreeNode<>(1);
        root.right.left.right.left = new BinaryTreeNode<>(401);
        root.right.left.right.right = new BinaryTreeNode<>(257);
        root.right.left.right.left.right = new BinaryTreeNode<>(641);

        root.right.right = new BinaryTreeNode<>(271);
        root.right.right.right = new BinaryTreeNode<>(28);

        System.out.println(inOrderTraversal(root));
        System.out.println(preOrderTraversal(root));
        System.out.println(postOrderTraversal(root));
    }
}
