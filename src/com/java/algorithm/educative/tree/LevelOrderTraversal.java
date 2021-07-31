package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static String levelOrderTraversal(
            BinaryTreeNode root) {
        // TODO: Write - Your - Code
        Queue<BinaryTreeNode> currentLevel = new ArrayDeque<BinaryTreeNode>();
        currentLevel.add(root);
        String result = "";
        while(!currentLevel.isEmpty()) {
            Queue<BinaryTreeNode> nextLevel = new ArrayDeque<BinaryTreeNode>();
            String thisLevel = "";
            while(! currentLevel.isEmpty()) {
                BinaryTreeNode current = currentLevel.poll();
                thisLevel += current.data + " ";
                if(current.left != null) nextLevel.add(current.left);
                if(current.right != null) nextLevel.add(current.right);
            }

            if(!thisLevel.equals("")) {
                System.out.println(thisLevel);
                result += thisLevel;
            }

            currentLevel = nextLevel;
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<Integer>();
        input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(300);
        input.add(12); input.add(35); input.add(60);
        BinaryTreeNode root = BinaryTree.create_BST(input);
        System.out.println("Level Order Traversal = " + levelOrderTraversal(root));
    }
}
