package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
    static String iterativeInorder(BinaryTreeNode root)
    {
        // TODD: Write - Your - Code
        Stack<BinaryTreeNode> stk = new Stack<>();
        String result = "";


        while(root != null || !stk.isEmpty()) {
            if(root != null) {
                stk.push(root);
                root = root.left;
            } else {
                BinaryTreeNode val = stk.pop();
                result = result + val.data + " ";
                root = val.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(300);
        input.add(12); input.add(35); input.add(60);
        BinaryTreeNode root = BinaryTree.create_BST(input);
        System.out.print("Inorder Iterative = ");
        System.out.println(iterativeInorder(root));
    }
}
