package com.java.algorithm.educative.tree.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public List<TreeNode> Children;

    public TreeNode(int x) {
        val = x;
        Children = new ArrayList<>();
    }

    // level order traversal using 'next' pointer
    public void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        /*while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }*/
        Queue<TreeNode> q = new LinkedList<>();
        q.add(nextLevelRoot);

        while(!q.isEmpty()) {
            int size = q.size();
            String thisLevel = "";
            TreeNode curr = q.poll();
            boolean leftMost = true;
            while(curr != null) {
                if(leftMost) {
                    if (curr.left != null) {
                        q.add(curr.left);
                    } else if(curr.right != null) {
                        q.add(curr.right);
                    }
                    leftMost = false;
                }
                thisLevel += curr.val + " ";
                curr = curr.next;
            }

            if(!thisLevel.equals("")) {
                System.out.println(thisLevel);
            }
        }
    }

    public static void display_level_order(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            StringBuilder thisLevel = new StringBuilder();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                node = queue.poll();
                assert node != null;
                thisLevel.append(node.val).append(" ");
                if(node.Children.size() > 0) {
                    queue.addAll(node.Children);
                }
            }

            if(!thisLevel.toString().equals("")) {
                System.out.println(thisLevel.toString());
            }
        }
    }


}
