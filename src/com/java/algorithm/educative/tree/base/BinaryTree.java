package com.java.algorithm.educative.tree.base;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTree {

    public static BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(BinaryTreeNode head) {
        this.root = head;
    }

    public static BinaryTreeNode insert(BinaryTreeNode root, int d) {

        BinaryTreeNode pNew = new BinaryTreeNode(d);
        if (root == null) {
            return pNew;
        }

        BinaryTreeNode parent = null;
        BinaryTreeNode pTemp = root;
        while (pTemp != null) {
            parent = pTemp;
            if (d <= pTemp.data) {
                pTemp = pTemp.left;
            } else {
                pTemp = pTemp.right;
            }
        }

        if (d <= parent.data) {
            parent.left = pNew;
            pNew.parent = parent;
        } else {
            parent.right = pNew;
            pNew.parent = parent;
        }
        return root;
    }

    public static BinaryTreeNode insert_BT(BinaryTreeNode root, int d) {

        BinaryTreeNode pNew = new BinaryTreeNode(d);
        if (root == null) {
            return pNew;
        }

        BinaryTreeNode parent = null;
        BinaryTreeNode pTemp = root;
        while (pTemp != null) {
            parent = pTemp;
            if (d <= pTemp.data) {
                pTemp = pTemp.left;
            } else {
                pTemp = pTemp.right;
            }
        }

        Random generator = new Random();
        int dir = generator.nextInt(1000);

        if (dir%2 == 0) {
            parent.left = pNew;
            pNew.parent = parent;
        } else {
            parent.right = pNew;
            pNew.parent = parent;
        }
        return root;
    }

    public static BinaryTreeNode find_in_bst(BinaryTreeNode root, int d){
        if(root == null)
            return null;

        if(root.data == d) {
            return root;
        }
        else if(root.data > d){
            return find_in_bst(root.left,d);
        }
        else{
            return find_in_bst(root.right,d);
        }
    }


    public static void display_inorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        display_inorder(node.left);
        if(node.parent != null)
        {
            //System.out.print(String.format("[%d - %d]",node.parent.data, node.count));
        }
        System.out.print(node.data + ", ");
        display_inorder(node.right);
    }

    public static void get_inorder(BinaryTreeNode node, List<Integer> output) {
        if (node == null) {
            return;
        }
        get_inorder(node.left, output);
        output.add(node.data);
        get_inorder(node.right, output);
    }

    public static void get_preorder(BinaryTreeNode node, List<Integer> output) {
        if (node == null) {
            return;
        }
        output.add(node.data);
        get_preorder(node.left, output);
        get_preorder(node.right, output);
    }

    public static BinaryTreeNode create_BST(List<Integer> l) {
        BinaryTreeNode root = null;
        for (Integer x : l) {
            root = insert(root, x);
        }
        return root;
    }

    public static BinaryTreeNode create_random_BST(int count, int max_value) {
        BinaryTreeNode root = null;
        for (int i = 0; i < count; ++i) {
            Random generator = new Random();
            root = insert(root, generator.nextInt(max_value));
        }
        return root;
    }

    public static BinaryTreeNode create_random_BST(int count) {
        return create_random_BST(count, Integer.MAX_VALUE);
    }

    public static BinaryTreeNode create_binary_tree(int count) {
        BinaryTreeNode root = null;
        for (int i = 0; i < count; ++i) {
            Random generator = new Random();
            root = insert_BT(root, generator.nextInt(100));
        }
        return root;
    }

    private static void populate_parents_rec(BinaryTreeNode root, BinaryTreeNode parent) {
        if (root == null) {
            return;
        }

        root.parent = parent;

        populate_parents_rec(root.left, root);
        populate_parents_rec(root.right, root);
    }

    public static void populate_parents(BinaryTreeNode root) {
        populate_parents_rec(root, null);
    }

    public static void bst_to_arraylist_rec(BinaryTreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        bst_to_arraylist_rec(root.left, arr);
        arr.add(root.data);
        bst_to_arraylist_rec(root.right, arr);
    }

    public static ArrayList<Integer> bst_to_arraylist(BinaryTreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        bst_to_arraylist_rec(root, arr);
        return arr;
    }

    public static void another_display_tree(BinaryTreeNode root, int tabs) {
        if (root != null) {
            int i;

            if (root.left != null) {
                for(i = 0; i < tabs+4; ++i) {
                    System.out.print(" ");
                }
                System.out.print("L" + root.left.data + "\n");
            }

            if (root.right != null) {
                for(i = 0; i < tabs+4; ++i) {
                    System.out.print(" ");
                }
                System.out.print("R" + root.right.data + "\n");
            }

            another_display_tree(root.left, tabs + 4);
            another_display_tree(root.right, tabs + 4);
        }
    }

    public static void another_display_tree(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + "\n");
            another_display_tree(root, 0);
        }
    }

    public static void display_level_order(BinaryTreeNode root) {
        if(root == null)
            return;

        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
        queue.addLast(root);

        while(!queue.isEmpty()){
            BinaryTreeNode temp = queue.removeFirst();
            System.out.print(temp.data + ", ");

            if(temp.left != null) {
                queue.addLast(temp.left);
                //System.out.println(temp.left.data + "LEFT");
            }

            if(temp.right != null){
                queue.addLast(temp.right);
                //System.out.println(temp.right.data + "RIGHT");
            }
        }
        System.out.println();
    }

    public static List<Integer> get_level_order(BinaryTreeNode root) {

        List<Integer> output = new ArrayList<Integer>();

        if(root == null)
            return output;

        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
        queue.addLast(root);

        while(!queue.isEmpty()){
            BinaryTreeNode temp = queue.removeFirst();
            // System.out.print(temp.data + ", ");
            output.add(temp.data);

            if(temp.left != null) {
                queue.addLast(temp.left);
                //System.out.println(temp.left.data + "LEFT");
            }

            if(temp.right != null){
                queue.addLast(temp.right);
                //System.out.println(temp.right.data + "RIGHT");
            }
        }
        return output;
    }

    public static boolean is_identical_tree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        else if (root1 != null && root2 != null) {
            return ((root1.data == root2.data) &&
                    is_identical_tree(root1.left, root2.left) &&
                    is_identical_tree(root1.right, root2.right));
        }
        else {
            return false;
        }
    }
}