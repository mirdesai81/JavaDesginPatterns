package com.java.algorithm.tree;

import java.util.Stack;

public class findKthNode {



   /* private int size(BinaryTreeNode<Integer> tree) {
        if(tree == null) {
            return 0;
        }

        return size(tree.left) + size(tree.right) + 1;
    }
*/

   public static Integer findKthNode(BinaryTreeNode<Integer> tree,int k) {
       BinaryTreeNode<Integer> curr = tree;
       while(curr != null) {
           int leftSize = curr.left == null ? 0 : size(curr.left);

           if(leftSize + 1 < k) {
               k -= (leftSize + 1);
               curr = curr.right;
           } else if(leftSize  == k - 1) {
               return curr.data;
           } else {
               curr = curr.left;
           }
       }

       return null;
   }

    private static int size(BinaryTreeNode<Integer> tree) {

       if(tree == null) {
           return 0;
       }

       Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(tree);
        int size = 0;
        while(!stack.isEmpty()) {
            BinaryTreeNode<Integer> temp = stack.pop();
            size++;
            if(temp != null) {
                if(temp.left != null) {
                    stack.push(temp.left);
                }

                if(temp.right != null) {
                    stack.push(temp.right);
                }
            }
        }

        return size;
    }

   public static void main(String[] args) {
       BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);

       // left subtree
       root.left = new BinaryTreeNode<>(15);
       root.left.left = new BinaryTreeNode<>(20);
       root.left.right = new BinaryTreeNode<>(30);


       //right subtree
       root.right = new BinaryTreeNode<>(25);
       root.right.left = new BinaryTreeNode<>(2);
       root.right.right = new BinaryTreeNode<>(10);

       System.out.println(findKthNode(root,2));
   }
}
