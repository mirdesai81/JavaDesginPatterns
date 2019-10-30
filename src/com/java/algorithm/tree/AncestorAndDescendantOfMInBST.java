package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

public class AncestorAndDescendantOfMInBST {

    public static boolean pairIncludesAncestorAndDescendantOfM(BSTNode<Integer> node0,
                                                               BSTNode<Integer> node1,
                                                               BSTNode<Integer> middle) {
        BSTNode<Integer> search0 = node0;
        BSTNode<Integer> search1 = node1;

        while(search0 != node1 && search0 != middle
                && search1 != node0 && search1 != middle
                && (search0 != null || search1 != null)) {
            if(search0 != null) {
                search0 = search0.data > middle.data ? search0.left : search0.right;
            }

            if(search1 != null) {
                search1 = search1.data > middle.data ? search1.left : search1.right;
            }
        }

        if(search0 == node1 || search1 == node0
                || (search0 != middle && search1 != middle)) {
            return false;
        }

        // If we get here, we already know one of node0 or
        // node1 has a path to middle. Check if middle has a path to
        // nodel or to node2 .
        return search0 == middle ? searchTarget(middle,node1) : searchTarget(middle,node0);
    }


    private static boolean searchTarget(BSTNode<Integer> from,
                                        BSTNode<Integer> target) {
        while(from != null && from != target) {
            from = from.data > target.data ? from.left : from.right;
        }

        return from == target;
    }

    public static void main(String[] args) {
        BSTNode<Integer> root = BSTUtil.createBST();
        StdOut.println(pairIncludesAncestorAndDescendantOfM(root.right.left.right.left.right , root.right.left, root.right.left.right));
    }
}
