package com.java.algorithm.tree;



public class LowestCommonAncestor {

    private static class Status {
      private Integer numOfTargetNodes;
      private BinaryTreeNode<String> ancestor;

        public Status(Integer numOfTargetNodes, BinaryTreeNode<String> ancestor) {
            this.numOfTargetNodes = numOfTargetNodes;
            this.ancestor = ancestor;
        }

        public Integer getNumOfTargetNodes() {
            return numOfTargetNodes;
        }

        public void setNumOfTargetNodes(Integer numOfTargetNodes) {
            this.numOfTargetNodes = numOfTargetNodes;
        }

        public BinaryTreeNode<String> getAncestor() {
            return ancestor;
        }

        public void setAncestor(BinaryTreeNode<String> ancestor) {
            this.ancestor = ancestor;
        }
    }

    public static BinaryTreeNode<String> LCA(BinaryTreeNode<String> tree,BinaryTreeNode<String> node1, BinaryTreeNode<String> node2) {
        if(tree == null) {
            return null;
        }

        if(tree == node1 || tree == node2) {
            return tree;
        }

        BinaryTreeNode<String> left = LCA(tree.left, node1, node2);
        BinaryTreeNode<String> right = LCA(tree.right,node1, node2);

        if(left != null && right != null) {
            return tree;
        }

        if(left == null && right == null) {
            return null;
        }

        return left != null ? left : right;
    }

    /*public static BinaryTreeNode<String> LCA(BinaryTreeNode<String> tree,BinaryTreeNode<String> node1,
                                               BinaryTreeNode<String> node2) {
        return LCAHelper(tree,node1,node2).ancestor;
    }*/




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
        if(left.numOfTargetNodes == 2) {
            return left;
        }

        Status right = LCAHelper(tree.right,node1,node2);
        if(right.numOfTargetNodes == 2) {
            return right;
        }


        int num = left.numOfTargetNodes + right.numOfTargetNodes + (tree == node1 ? 1 : 0) + (tree == node2 ? 1: 0);

        return new Status(num,num == 2 ? tree : null);

    }

    public static void main(String[] args) {
        BinaryTreeNode<String> root = new BinaryTreeNode<String>("A");
        //left
        root.left = new BinaryTreeNode<>("B");
        root.left.left = new BinaryTreeNode<>("C");
        root.left.right = new BinaryTreeNode<>("F");
        root.left.left.left = new BinaryTreeNode<>("D");
        root.left.left.right = new BinaryTreeNode<>("E");
        root.left.right.right = new BinaryTreeNode<>("G");
        root.left.right.right.left = new BinaryTreeNode<>("H");

        //right
        root.right = new BinaryTreeNode<>("I");
        root.right.left = new BinaryTreeNode<>("J");
        root.right.right = new BinaryTreeNode<>("0");
        root.right.right.right = new BinaryTreeNode<>("P");
        root.right.left.right = new BinaryTreeNode<>("K");
        root.right.left.right.right = new BinaryTreeNode<>("N");
        root.right.left.right.left = new BinaryTreeNode<>("L");
        root.right.left.right.left.right = new BinaryTreeNode<>("M");

        // LCA of
        BinaryTreeNode<String> lca = LCA(root,root.right.left.right.right, root.right.left.right.left.right);
        System.out.println(lca.data);
    }
}
