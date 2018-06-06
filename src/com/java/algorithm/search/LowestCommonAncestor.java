package com.java.algorithm.search;



public class LowestCommonAncestor {

    private static class Status {
        public int num;
        public BinaryTreeNode<Integer> ancestor;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public BinaryTreeNode<Integer> getAncestor() {
            return ancestor;
        }

        public void setAncestor(BinaryTreeNode<Integer> ancestor) {
            this.ancestor = ancestor;
        }

        public Status(int num, BinaryTreeNode<Integer> ancestor) {
            this.num = num;
            this.ancestor = ancestor;
        }
    }

    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> tree,BinaryTreeNode<Integer> node1,
                                               BinaryTreeNode<Integer> node2) {
        return LCAHelper(tree,node1,node2).ancestor;
    }

    // Returns an object consisting of an int and a node. The int field is
    // 0, 1, or 2 depending on how many of {node1 , node2} are present in
    // the tree. If both are present in the tree, when ancestor is
    // assigned to a non-null value, it is the LCA.
    private static Status LCAHelper(BinaryTreeNode<Integer> tree,BinaryTreeNode<Integer> node1,
                                    BinaryTreeNode<Integer> node2) {
        if(tree == null) {
            return new Status(0,null);
        }

        Status left = LCAHelper(tree.left,node1,node2);
        if(left.num == 2) {
            return left;
        }

        Status right = LCAHelper(tree.right,node1,node2);
        if(right.num == 2) {
            return right;
        }


        int num = left.num + right.num + (tree == node1 ? 1 : 0) + (tree == node2 ? 1: 0);

        return new Status(num,num == 2 ? tree : null);

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);
        root.left = new BinaryTreeNode<>(46);
        root.left.right = new BinaryTreeNode<>(12);
        root.left.left = new BinaryTreeNode<>(14);
        root.left.right.right = new BinaryTreeNode<>(13);
        root.left.right.left = new BinaryTreeNode<>(16);

        root.right = new BinaryTreeNode<>(36);
        root.right.left = new BinaryTreeNode<>(22);
        root.right.right = new BinaryTreeNode<>(24);
        root.right.left.left = new BinaryTreeNode<>(23);
        root.right.left.right = new BinaryTreeNode<>(26);
        BinaryTreeNode<Integer> lca = LCA(root,root.right.left.left, root.right.left.right);
        System.out.println(lca.data);
    }
}
