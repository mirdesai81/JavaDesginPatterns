package com.java.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DepthBST {

    public static int minDepth(BinaryTreeNode<Integer> root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        if(root.left == null) {
            return minDepth(root.right) + 1;
        }

        if(root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }

    public static int maxDepth(BinaryTreeNode<Integer> root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        int depth = 1;
        Queue<BinaryTreeNode> curr = new LinkedList<>();
        curr.add(root.left);
        curr.add(root.right);

        while(!curr.isEmpty()) {
            Queue<BinaryTreeNode> next = new LinkedList<>();
            while(!curr.isEmpty()) {
                BinaryTreeNode currNode = curr.poll();

                if(currNode != null) {
                    next.add(currNode.left);
                    next.add(currNode.right);
                }
            }

            depth++;
            curr = next;
        }

        return depth > 0 ? depth - 1 : 1;
    }
}
