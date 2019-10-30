package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

public class LowestCommonAncestorBST {

    public static BSTNode<Integer> lca(BSTNode<Integer> tree,BSTNode<Integer> node1,BSTNode<Integer> node2) {

        BSTNode<Integer> p = tree;

        while(p.data < node1.data || p.data > node2.data) {
            while(p.data < node1.data) {
                p = p.right;
            }

            while(p.data > node2.data) {
                p = p.left;
            }
        }

        // now p.data >= node1.data and p.data <= node2.data
        return p;
    }

    public static void main(String[] args) {
        BSTNode<Integer> tree = BSTUtil.createBST();

        BSTNode<Integer> node1 = tree.left.left.left;
        BSTNode<Integer> node2 = tree.left.left.right;

        BSTNode<Integer> lca = lca(tree,node1,node2);
        StdOut.println(lca.data);
    }



}
