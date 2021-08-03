package com.java.algorithm.educative.tree;

import com.java.algorithm.educative.tree.base.BinaryTree;
import com.java.algorithm.educative.tree.base.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ConnectAllSiblings {


        public static void populateSiblingPointers(BinaryTreeNode root) {
            if(root == null)
                return;

            Queue<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
            queue.offer(root);
            BinaryTreeNode prev = null;

            while(!queue.isEmpty()){
                BinaryTreeNode temp = queue.poll();

                if(prev != null) {
                    prev.next = temp;
                }

                prev = temp;

                if(temp.left != null){
                    queue.offer(temp.left);
                }

                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }

            if(prev != null)
                prev.next = null;
        }

        public static List<Integer> getLevelOrderTraversalWithSibling(BinaryTreeNode root)
        {
            List<Integer> l = new ArrayList<Integer>();
            while(root != null) {
                l.add(root.data);
                root = root.next;
            }
            return l;
        }

        public static void main(String[] args) {

            List<Integer> input = new ArrayList<Integer>();
            input.add(100);input.add(50);input.add(200);input.add(25);input.add(75);input.add(125);input.add(350);
            BinaryTreeNode root = BinaryTree.create_BST(input);

            populateSiblingPointers(root);

            List<Integer> l2 = getLevelOrderTraversalWithSibling(root);
            System.out.println(l2);
        }

}
