package com.java.algorithm.educative.tree;


import com.java.algorithm.educative.tree.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree {

        public static int findDepth(TreeNode root) {
            // TODO: Write your code here
            int minDept = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            TreeNode curr = null;
            while(!q.isEmpty()) {
                int size = q.size();

                minDept++;

                for(int i = 0 ; i < size; i++) {
                    curr = q.poll();
                    if(curr.left == null && curr.right == null) {
                        return minDept;
                    }

                    if(curr.left != null) q.offer(curr.left);

                    if(curr.right != null) q.offer(curr.right);
                }

            }
            return minDept;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            System.out.println("Tree Minimum Depth: " + findDepth(root));
            root.left.left = new TreeNode(9);
            root.right.left.left = new TreeNode(11);
            System.out.println("Tree Minimum Depth: " + findDepth(root));
        }
}
