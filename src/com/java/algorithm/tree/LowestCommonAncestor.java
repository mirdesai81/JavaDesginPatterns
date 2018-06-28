package com.java.algorithm.tree;



public class LowestCommonAncestor {

    private static class Status {
        public int num;
        public BinaryTreeNode<String> ancestor;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public BinaryTreeNode<String> getAncestor() {
            return ancestor;
        }

        public void setAncestor(BinaryTreeNode<String> ancestor) {
            this.ancestor = ancestor;
        }

        public Status(int num, BinaryTreeNode<String> ancestor) {
            this.num = num;
            this.ancestor = ancestor;
        }
    }

    public static BinaryTreeNode<String> LCA(BinaryTreeNode<String> tree,BinaryTreeNode<String> node1,
                                               BinaryTreeNode<String> node2) {
        return LCAHelper(tree,node1,node2).ancestor;
    }

    // Returns an object consisting of an int and a node. The int field is
    // 0, 1, or 2 depending on how many of {node1 , node2} are present in
    // the tree. If both are present in the tree, when ancestor is
    // assigned to a non-null value, it is the LCA.
    private static Status LCAHelper(BinaryTreeNode<String> tree,BinaryTreeNode<String> node1,
                                    BinaryTreeNode<String> node2) {
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
        BinaryTreeNode<String> root = new BinaryTreeNode<String>("A");
        //left
        root.left = new BinaryTreeNode<>("B");
        root.left.left = new BinaryTreeNode<>("C");
        root.left.right = new BinaryTreeNode<>("H");
        root.left.left.left = new BinaryTreeNode<>("D");
        root.left.left.right = new BinaryTreeNode<>("G");
        root.left.left.left.left = new BinaryTreeNode<>("E");
        root.left.left.left.right = new BinaryTreeNode<>("F");
        root.left.right.left = new BinaryTreeNode<>("I");
        root.left.right.right = new BinaryTreeNode<>("J");
        //right
        root.right = new BinaryTreeNode<>("K");
        root.right.left = new BinaryTreeNode<>("L");
        root.right.right = new BinaryTreeNode<>("O");
        root.right.left.left = new BinaryTreeNode<>("M");
        root.right.left.right = new BinaryTreeNode<>("N");
        BinaryTreeNode<String> lca = LCA(root,root.right.left.left, root.right.left.right);
        System.out.println(lca.data);
    }
}
