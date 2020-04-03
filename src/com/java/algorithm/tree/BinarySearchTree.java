package com.java.algorithm.tree;

import com.java.algorithm.queue.Queue;
import com.java.stdlib.StdOut;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by mihir.desai on 2/2/2018.
 */
public class BinarySearchTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        //else return x.N;
        Stack<Node> stack = new Stack<>();
        int size = 0;
        stack.push(x);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            size++;
            if(curr.right != null) {
                stack.push(curr.right);
            }

            if(curr.left != null) {
                stack.push(curr.left);
            }
        }

        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node x, Key key) {
        if(key == null)
            throw new IllegalArgumentException("called get() with null key");

        while(x != null) {
            int cmp = key.compareTo(x.key);

            // left subtree
            if(cmp < 0) {
                x = x.left;
            } else if(cmp > 0) { // right subtree
                x = x.right;
            } else {
                return x.value;
            }
        }

        return null;
    }

    public boolean contains(Key key) {
        if(key == null) throw new IllegalArgumentException("called contains() with null key");

        return get(key) != null;
    }

    public void put(Key key,Value value) {
        if(key == null) throw new IllegalArgumentException("called put() with null key");

        if(value == null) {
            // delete key and return
        }

        root = put(root,key,value);
    }

    private Node put(Node x,Key key,Value value) {
        if(x == null) return new Node(key,value,1);
        /*int cmp = key.compareTo(x.key);

        if(cmp < 0) {
            x.left = put(x.left,key,value);
        } else if(cmp > 0) {
            x.right = put(x.right,key,value);
        } else {
            // update the value
            x.value = value;
        }*/
        Node curr = x;
        Node prev = null;
        Node newNode = new Node(key,value,1);
        while(curr != null) {
            prev = curr;
            int cmp = key.compareTo(curr.key);
            if(cmp < 0) {
                curr = curr.left;
            } else if(cmp > 0) {
                curr = curr.right;
            } else  {
                curr.value = value;
                break;
            }
        }

        if(key.compareTo(prev.key) < 0) {
            prev.left = newNode;
        } else if(key.compareTo(prev.key) > 0) {
            prev.right = newNode;
        }


        return x;
    }

    public Key min() {
        if(root == null)
            return null;

        return min(root).key;
    }

    private Node min(Node x) {
        if(x.left == null) return x;
        x = x.left;
        while(x.left != null) {
            x = x.left;
        }
        return x;
    }

    public Key max() {
        if(root == null) return null;
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right == null) return x;
        x = x.right;

        while(x.right != null){
            x = x.right;
        }

        return x;
    }

    public Key floor(Key key) {
        if(key == null) throw new IllegalArgumentException("called floor() with null key");
        if(isEmpty()) throw new NoSuchElementException("BST is empty");
        Node x = floor(root,key);
        if(x == null) return null;

        return x.key;
    }

    /**
     * Floor of given key is the largest value less or equal than given key
     * returns node is which equal to given key or just less than given key
     * @param x
     * @param key
     * @return
     */
    private Node floor(Node x,Key key) {
        if(x == null) {
            return null;
        }
        Node floor = null;
        while(x != null) {
            int cmp = key.compareTo(x.key);

            if(cmp == 0) {
                return x;
            } else if(cmp < 0) {
                x = x.left;
            } else {
                floor = x;
                x = x.right;
            }
        }

        if(floor != null) {
            return floor;
        }

        return null;
    }

    /**
     * Ceil of given key is the smallest value greater than given key
     * @param key
     * @return
     */
    public Key ceil(Key key) {
        if(key == null) throw new IllegalArgumentException("called ceil() with null key");
        if(isEmpty()) throw new NoSuchElementException("BST is empty");
        Node x = ceil(root,key);
        if(x == null) return null;

        return x.key;
    }

    private Node ceil(Node x,Key key) {
        if(x == null) return null;
        Node ceil = null;
        while(x != null) {
            int cmp = key.compareTo(x.key);

            if(cmp == 0) {
                return x;
            } else if(cmp > 0) {
                x = x.right;
            } else {
                ceil = x;
                x = x.left;
            }
        }

        if(ceil != null){
            return ceil;
        }

        return null;
    }

    /**
     * Find the rank for a given key
     * Initialize rank = 0
     * while x != null
     *      Compare key with x.key
     *      if key < then x = x.left;
     *      if k > then rank = rank + 1 + size(x.left) and x = x.right
     *      if k = then return rank = rank + size(x.left)
     * end while
     * return rank
     * @param key
     * @return int
     */
    public int rank(Key key) {
        return rank(root,key);
    }

    private int rank(Node x,Key key) {
        if(x == null) return 0;

        int rank = 0;
        while(x != null) {
            int cmp = key.compareTo(x.key);
            System.out.println("Key : "+x.key);
            if(cmp == 0) {
                return size(x.left) + rank;
            } else if (cmp < 0) {
                x = x.left;
            } else  {
                rank += 1 + size(x.left);
                x = x.right;
            }
        }

        return rank;
    }

    public Key select(int k) {
        if(k < 0 || k > size()) {
            throw new IllegalArgumentException("called select() with invalid argument k - "+k);
        }

        Node x = select(root,k);
        if(x == null) return null;

        return x.key;
    }

    private Node select(Node x,int k) {
        if(x == null) return null;


       /* while(x != null) {
            int leftSize = size(x.left);

            if(k > leftSize + 1) { // k must be in right subtree
                k = k - (leftSize + 1);
                x = x.right;
            } else if(k == leftSize + 1) {
                return x;
            } else {
                x = x.left;
            }

        }*/



        while(x != null) {
            int t = size(x.left);

            if(t > k) {
                x = x.left;
            } else if(t < k) {
                k = k - t - 1;
                x = x.right;
            } else {
                return x;
            }
        }

        return null;
    }

    public void deleteMin() {
        if(isEmpty()) throw new NoSuchElementException("Binary tree tree is empty");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
      /*  if(x.left == null) return x.right;
        Node parent = null;
        while(x.left != null) {
            x.N = x.N - 1;
            parent = x;
            x = x.left;
        }

        if(x.right != null) {
            parent.left = x.right;
        } else {
            parent.left = null;
        }
        x = null;
        return root;*/
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMax() {
        if(isEmpty()) throw new NoSuchElementException("Binary tree tree is empty");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if(x.right == null) return x.left;

        x.right = deleteMax(x.right);
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key key) {
        if(isEmpty()) throw new NoSuchElementException("BST is empty");
        root = delete(root,key);
    }

    private Node delete(Node x,Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);

        if(cmp < 0) x.left = delete(x.left,key);
        else if(cmp > 0) x.right = delete(x.right,key);
        else {
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root,queue,lo,hi);
        return queue;
    }

    private void keys(Node x,Queue<Key> queue,Key lo, Key hi){
        if(x == null) return;
        int cmpLo = lo.compareTo(x.key);
        int cmpHi = hi.compareTo(x.key);
        if(cmpLo < 0) {keys(x.left,queue,lo,hi);}
        if(cmpLo <= 0 && cmpHi >= 0) {queue.enqueue(x.key);}
        if(cmpHi > 0) {keys(x.right,queue,lo,hi);}
    }



    public Iterable<Key> IterativeKeys() {
       /* Stack<Node> stack = new Stack<>();
        Node curr = root;
        Queue<Key> queue = new Queue<>();
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                queue.enqueue(curr.key);
                curr = curr.right;
            }
        }

        return queue;*/
        return IterativeKeys(min(),max());
    }

    public Iterable<Key> IterativeKeys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        IterativeKeys(root,queue,lo,hi);
        return queue;
    }

    private void IterativeKeys(Node x,Queue<Key> queue,Key lo,Key hi) {
        Stack<Node> stack = new Stack<>();
        while(x != null || !stack.isEmpty()) {
            if(x != null) {
                stack.push(x);
                x = x.left;
            } else  {
                x = stack.pop();
                int cmpLo = lo.compareTo(x.key);
                int cmpHi = hi.compareTo(x.key);
                if(cmpLo <= 0 && cmpHi >= 0) {
                    queue.enqueue(x.key);
                }
                x = x.right;
            }
        }
    }

    /**
     * Returns the keys in the BST in level order (for debugging).
     *
     * @return the keys in the BST in level order traversal
     */
    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }


    public int height() {
        return height(root);
    }

    // Similar to level order just we maintain additional null node as marker for end of level to increment height
    private int height(Node x) {
        if(x == null) return -1;

        if(x.left == null && x.right == null) return 1;
        Queue<Node> queue = new Queue<>();
        queue.enqueue(x);
        queue.enqueue(null);
        int height = 0;

        while(!queue.isEmpty()){
            x = queue.dequeue();

            if(x == null) {
                if(!queue.isEmpty()) {
                    queue.enqueue(null);
                }
                height++;
            } else {
                if(x.left != null)
                    queue.enqueue(x.left);

                if(x.right != null)
                    queue.enqueue(x.right);
            }
        }

        return height;
    }


    /**
     * Returns the number of keys in the symbol table in the given range.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return the number of keys in the symbol table between {@code lo}
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }

    private boolean check() {
        if (!isBST())            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.N != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }


    public void preOrder() {
       Node x = root;
       preOrder(x);
       StdOut.println("");
    }

    private void preOrder(Node x) {
        if(x != null) {
            StdOut.print(x.key);
            preOrder(x.left);
            preOrder(x.right);
        }
    }

    /**
     * ROOT L R
     */
    public void preOrderItr() {
        preOrderItr(root);
    }

    public void preOrderItr(Node root) {
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node x = stack.pop();
           StdOut.print(x.key);
           if(x.right != null) {
               stack.push(x.right);
           }
           if(x.left != null) {
               stack.push(x.left);
           }
        }
    }

    public void inOrder() {
        Node x = root;
        inOrder(x);
        StdOut.println("");
    }

    public void inOrder(Node x) {
        if(x != null) {
            inOrder(x.left);
            StdOut.print(x.key);
            inOrder(x.right);
        }

    }

    /**
     * L Root R
     */
    public void inOrderItr() {
        inOrderItr(root);
    }

    public void inOrderItr(Node root) {
        Stack<Node> stack = new Stack<>();
        Node x = root;
        while(!stack.isEmpty() || x != null) {
            if(x != null) {
                stack.push(x);
                x = x.left;
            } else {
                x = stack.pop();
                StdOut.print(x.key);
                x = x.right;
            }
        }
    }


    public void higestToSmallestItr() {
        higestToSmallestItr(root);
    }

    public void higestToSmallestItr(Node root) {
        Stack<Node> stack = new Stack<>();
        Node x = root;
        while(x != null || !stack.isEmpty()) {
            if(x != null) {
                stack.push(x);
                x = x.right;
            } else {
                x = stack.pop();
                StdOut.print(x.key);
                x = x.left;
            }
        }
    }



    public void postOrder() {
        Node x = root;
        postOrder(x);
        StdOut.println("");
    }

    public void postOrder(Node x) {
        if(x != null) {
            postOrder(x.left);
            postOrder(x.right);
            StdOut.print(x.key);

        }

    }


    public void postOrderItr() {
        postOrderItr(root);
    }

    public void postOrderItr(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                Node temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    StdOut.print(temp.key);
                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        StdOut.print(temp.key);
                    }
                } else {
                    curr = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
       /* BinarySearchTree<Character,Integer> bst = new BinarySearchTree<>();
        String inputStr = "SEARCHEXAMPLE";
        char[] inputData = inputStr.toCharArray();
        int i = 1;
        for(char c : inputData) {
            bst.put(c,i);
            i++;
        }


        bst.delete('E');

        bst.preOrder();
        StdOut.println();
       bst.inOrder();
        StdOut.println();
       bst.postOrder();
        StdOut.println();


       bst.inOrderItr();
        StdOut.println();


       bst.higestToSmallestItr();
        StdOut.println();
        System.out.println("Select(5) - "+bst.select(5));
        System.out.println("Select(1) - "+bst.select(1));
        System.out.println("Select(9) - "+bst.select(9));

        for (Character s : bst.levelOrder())
            StdOut.println(s + " " + bst.get(s));

        System.out.println("Rank of M - "+bst.rank('M'));
        System.out.println("Rank of A - "+bst.rank('A'));
        System.out.println("Rank of X - "+bst.rank('X'));
        bst.height();*/

    /*    System.out.println("Min key for BST - "+bst.min());
        System.out.println("Max key for BST - "+bst.max());

        System.out.println("Floor for key G - "+bst.floor('G'));
        System.out.println("Floor for key N - "+bst.floor('N'));
        System.out.println("Floor for key Z - "+bst.floor('Z'));

        System.out.println("Ceil for key G - "+bst.ceil('G'));
        System.out.println("Ceil for key N - "+bst.ceil('N'));
        System.out.println("Ceil for key Z - "+bst.ceil('Z'));

        System.out.println("Rank of M - "+bst.rank('M'));
        System.out.println("Rank of C - "+bst.rank('C'));
        System.out.println("Rank of X - "+bst.rank('X'));

        System.out.println("Select(5) - "+bst.select(5));
        System.out.println("Select(1) - "+bst.select(1));
        System.out.println("Select(9) - "+bst.select(9));*/


       /* System.out.println("Delete min - ");
        bst.deleteMin();
        System.out.println("Rank of C - "+bst.rank('C'));
        System.out.println("Select(1) - "+bst.select(1));*/

    /*    for (Character s : bst.levelOrder())
            StdOut.println(s + " " + bst.get(s));

        bst.delete('E');

        for (Character s : bst.levelOrder())
            StdOut.println(s + " " + bst.get(s));*/

        /*for(Character s : bst.keys()) {
            StdOut.println(s + " " + bst.get(s));
        }*/

        /*for(Character s : bst.IterativeKeys('X','Z')) {
            StdOut.println(s + " " + bst.get(s));
        }

        StdOut.println("Height of tree - "+ bst.height());*/


        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();

        int[] inputData = new int[] {15,10,18,8, 11,16,20,19,21};
        int i = 1;
        for(int c : inputData) {
            bst.put(c,i);
            i++;
        }

        for(Integer x : bst.levelOrder()) {
            StdOut.print(x+" ");
        }



      /*  StdOut.println("Select(0) - "+bst.select(0));

        bst.delete(18);*/


    }
}
