package com.java.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ExteriorBST {

    public static List<BinaryTreeNode<Integer>> findExteriorOfTree(BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> result = new LinkedList<>();
        if(tree != null) {
            result.add(tree);
            result.addAll(findLeftBoundaryAndLeaves(tree.left,true));
            result.addAll(findRightBoundaryAndLeaves(tree.right,true));
        }

        return result;
    }


    private static List<BinaryTreeNode<Integer>> findLeftBoundaryAndLeaves(BinaryTreeNode<Integer> subTree,boolean isBoundary) {
        List<BinaryTreeNode<Integer>> result = new LinkedList<>();

        if(subTree != null) {
            if(isBoundary || isLeaf(subTree)) {
                result.add(subTree);
            }

            result.addAll(findLeftBoundaryAndLeaves(subTree.left,isBoundary));
            result.addAll(findLeftBoundaryAndLeaves(subTree.right, isBoundary && subTree.left == null));
        }

        return result;
    }

    private static List<BinaryTreeNode<Integer>> findRightBoundaryAndLeaves(BinaryTreeNode<Integer> subTree,boolean isBoundary) {
        List<BinaryTreeNode<Integer>> result = new LinkedList<>();

        if(subTree != null) {
            result.addAll(findRightBoundaryAndLeaves(subTree.left,isBoundary && subTree.right == null));
            result.addAll(findRightBoundaryAndLeaves(subTree.right,isBoundary));

            if(isBoundary || isLeaf(subTree)) {
                result.add(subTree);
            }
        }

        return result;
    }

    private static boolean isLeaf(BinaryTreeNode<Integer> subtree) {
        if(subtree.left == null && subtree.right == null) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        HeightBST tree = new HeightBST();
        BinaryTreeNode<Integer> root = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        root = tree.insert(root,9);
        root = tree.insert(root,13);

        List<BinaryTreeNode<Integer>> exteriorList = findExteriorOfTree(root);

        System.out.println(exteriorList.stream().map(x -> x.data.toString()).collect(Collectors.joining("->")));
    }
}
