package com.java.algorithm.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTreeFromPreorderInorder {

    public static BinaryTreeNode<Integer> binaryTreeFromPreorderInorder(List<Integer> preorder,List<Integer> inorder) {
        Map<Integer,Integer> nodeToInorderIdx = IntStream.range(0,inorder.size()).boxed().collect(Collectors.toMap(inorder::get, i -> i));
        return binaryTreeFromPreorderInorderHelper(preorder,0,preorder.size(),
                0,inorder.size(),
                nodeToInorderIdx);
    }

    public static BinaryTreeNode<Integer> binaryTreeFromPreorderInorderHelper(
            List<Integer> preorder,int preorderStart,int preorderEnd,
            int inorderStart, int inorderEnd,
            Map<Integer, Integer> nodeToInorderIdx) {

        if(preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }

        int rootInOrderIdx = nodeToInorderIdx.get(preorder.get(preorderStart));
        int leftSubTreeSize = rootInOrderIdx - inorderStart;

        return new BinaryTreeNode<>(preorder.get(preorderStart),
                binaryTreeFromPreorderInorderHelper(preorder, preorderStart + 1, preorderStart + 1 + leftSubTreeSize,
                        inorderStart, rootInOrderIdx,nodeToInorderIdx),
        binaryTreeFromPreorderInorderHelper(preorder,preorderStart + 1 + leftSubTreeSize,preorderEnd,
                rootInOrderIdx + 1, inorderEnd,nodeToInorderIdx));

    }

    public static void main(String[] args) {
        List<Integer> inOrder = Arrays.asList(561,6,314,0,17,271,28,20,3);
        List<Integer> preOrder = Arrays.asList(17,6,561,0,314,271,28,3,20);
        BinaryTreeNode<Integer> tree = binaryTreeFromPreorderInorder(preOrder,inOrder);
        System.out.println(tree.toString());
    }
}
