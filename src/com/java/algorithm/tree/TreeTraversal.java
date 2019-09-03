package com.java.algorithm.tree;

import java.util.*;

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
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        while(!stack.isEmpty() || curr != null) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BinaryTreeNode<Integer> temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    result.add(temp.data);
                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        result.add(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }
        }

        return result;
    }

    public static List<Integer> inOrderTraversalWithParent(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> prev = null, curr = root;
        List<Integer> result = new ArrayList<>();
        while(curr != null) {
            BinaryTreeNode<Integer> next;

            if(curr.parent == prev) {
                if(curr.left != null) {
                    next = curr.left;
                } else {
                    result.add(curr.data);
                    next = curr.right != null ? curr.right : curr.parent;
                }
            } else if(curr.left == prev) {
                result.add(curr.data);
                next = curr.right != null ? curr.right : curr.parent;
            } else { // done with both children so move up
                next = curr.parent;
            }

            prev = curr;
            curr = next;

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


        root = new BinaryTreeNode<>(314);

        // left subtree
        root.left = new BinaryTreeNode<>(6);
        root.left.parent = root;

        root.left.left = new BinaryTreeNode<>(271);
        root.left.left.parent = root.left;

        root.left.left.left = new BinaryTreeNode<>(28);
        root.left.left.left.parent = root.left.left;
        root.left.left.right = new BinaryTreeNode<>(0);
        root.left.left.right.parent = root.left.left;

        root.left.right = new BinaryTreeNode<>(561);
        root.left.right.parent = root.left;


        root.left.right.right = new BinaryTreeNode<>(3);
        root.left.right.right.parent = root.left.right;
        root.left.right.right.left = new BinaryTreeNode<>(17);
        root.left.right.right.left.parent = root.left.right.right;

        //right subtree
        root.right = new BinaryTreeNode<>(6);
        root.right.parent = root;
        root.right.left = new BinaryTreeNode<>(2);
        root.right.left.parent = root.right;
        root.right.left.right = new BinaryTreeNode<>(1);
        root.right.left.right.parent = root.right.left;
        root.right.left.right.left = new BinaryTreeNode<>(401);
        root.right.left.right.left.parent = root.right.left.right;

        root.right.left.right.right = new BinaryTreeNode<>(257);
        root.right.left.right.right.parent = root.right.left.right;
        root.right.left.right.left.right = new BinaryTreeNode<>(641);
        root.right.left.right.left.right.parent = root.right.left.right.left;

        root.right.right = new BinaryTreeNode<>(271);
        root.right.right.parent = root.right;
        root.right.right.right = new BinaryTreeNode<>(28);
        root.right.right.right.parent = root.right.right;
        System.out.println(inOrderTraversalWithParent(root));
    }
}
