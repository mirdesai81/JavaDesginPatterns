package com.java.algorithm.tree;

import com.java.algorithm.tree.BinaryTreeNode;
import com.java.stdlib.StdOut;

import java.util.*;
import java.util.Queue;

public class BinaryTreeDepthOrder {

    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
       List<List<Integer>> result = new ArrayList<>();

       Queue<BinaryTreeNode<Integer>> currLevel = new LinkedList<>();
       currLevel.add(tree);

       while(!currLevel.isEmpty()) {
           Queue<BinaryTreeNode<Integer>> nextLevel = new LinkedList<>();
           List<Integer> thisLevel = new ArrayList<>();

           while (!currLevel.isEmpty()) {
               BinaryTreeNode<Integer> currNode = currLevel.poll();
               if(currNode != null) {
                   thisLevel.add(currNode.data);
                   nextLevel.add(currNode.getLeft());
                   nextLevel.add(currNode.getRight());
               }
           }

           if(!thisLevel.isEmpty()) {
               result.add(thisLevel);
           }

           currLevel = nextLevel;
       }

       return result;
    }

    public static List<List<Integer>> binaryTreeDepthOrderAlt(BinaryTreeNode<Integer> tree) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> currDepthNodes = new LinkedList<BinaryTreeNode<Integer>>();
        currDepthNodes.add(tree);

        while(!currDepthNodes.isEmpty()) {
            Queue<BinaryTreeNode<Integer>> nextDepthNodes = new LinkedList<BinaryTreeNode<Integer>>();
            List<Integer> thisLevel = new ArrayList<>();
            boolean changeDirection = false;
            while(!currDepthNodes.isEmpty()) {
                BinaryTreeNode<Integer> currNode = currDepthNodes.poll();
                if(currNode != null) {
                    thisLevel.add(currNode.getData());

                    if(!changeDirection) {
                        nextDepthNodes.add(currNode.getLeft());
                        nextDepthNodes.add(currNode.getRight());
                        changeDirection = true;
                    } else {
                        nextDepthNodes.add(currNode.getRight());
                        nextDepthNodes.add(currNode.getLeft());
                        changeDirection = false;
                    }
                }
            }

            if(!thisLevel.isEmpty()) {
                result.add(thisLevel);
            }

            currDepthNodes = nextDepthNodes;
        }

        return result;
    }


    public static List<List<Integer>> binaryTreeDepthOrderBottomUp(BinaryTreeNode<Integer> tree) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<BinaryTreeNode<Integer>> currDepthNodes = new LinkedList<BinaryTreeNode<Integer>>();
        currDepthNodes.add(tree);

        while(!currDepthNodes.isEmpty()) {
            Queue<BinaryTreeNode<Integer>> nextDepthNodes = new LinkedList<BinaryTreeNode<Integer>>();
            List<Integer> thisLevel = new ArrayList<>();
            while(!currDepthNodes.isEmpty()) {
                BinaryTreeNode<Integer> currNode = currDepthNodes.poll();
                if(currNode != null) {
                    thisLevel.add(currNode.getData());

                    nextDepthNodes.add(currNode.getLeft());
                    nextDepthNodes.add(currNode.getRight());
                }
            }

            if(!thisLevel.isEmpty()) {
                stack.push(thisLevel);
            }

            currDepthNodes = nextDepthNodes;
        }

        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }


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

    public static int maxDepthRecursive(BinaryTreeNode<Integer> root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        if(root.left == null) return maxDepthRecursive(root.right) + 1;

        if(root.right == null) return maxDepthRecursive(root.left) + 1;

        return Math.max(maxDepthRecursive(root.left),maxDepthRecursive(root.right)) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> parent = new BinaryTreeNode<>(314);
        parent.setLeft(new BinaryTreeNode<>(6));
        parent.setRight(new BinaryTreeNode<>(6));

        parent.getLeft().setLeft(new BinaryTreeNode<>(271));
        parent.getLeft().setRight(new BinaryTreeNode<>(561));
        parent.getRight().setLeft(new BinaryTreeNode<>(2));
        parent.getRight().setRight(new BinaryTreeNode<>(271));

        parent.getLeft().getLeft().setLeft(new BinaryTreeNode<>(28));
        parent.getLeft().getLeft().setRight(new BinaryTreeNode<>(271));
        parent.getLeft().getRight().setLeft(new BinaryTreeNode<>(0));
        parent.getLeft().getRight().setRight(new BinaryTreeNode<>(3));

        parent.getRight().getLeft().setLeft(new BinaryTreeNode<>(1));
        parent.getRight().getLeft().setRight(new BinaryTreeNode<>(28));
        parent.getRight().getRight().setLeft(new BinaryTreeNode<>(5));
        parent.getRight().getRight().setRight(new BinaryTreeNode<>(10));

        parent.getRight().getLeft().getLeft().setLeft(new BinaryTreeNode<>(17));
        parent.getRight().getLeft().getLeft().setRight(new BinaryTreeNode<>(401));
        parent.getRight().getLeft().getRight().setLeft(new BinaryTreeNode<>(257));

        System.out.println(binaryTreeDepthOrder(parent));
        System.out.println(binaryTreeDepthOrderAlt(parent));


        System.out.println(binaryTreeDepthOrderBottomUp(parent));

        StdOut.println("MAX Dept of BST - "+maxDepth(parent));
        StdOut.println("MAX Dept of BST - "+maxDepthRecursive(parent));

        StdOut.println("MIN Dept of BST - "+minDepth(parent));

    }
}
