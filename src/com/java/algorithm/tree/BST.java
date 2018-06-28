package com.java.algorithm.tree;

import com.java.algorithm.queue.Queue;
import com.java.stdlib.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by Mihir.Desai on 4/27/2017.
 */
public class BST<K extends Comparable<K>,V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left,right;
        private int size;

        public Node(K key,V val,int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST() {

    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x){
        if( x== null) return 0;
        return x.size;
    }

    public boolean contains(K key) {
        if(key == null) throw new IllegalArgumentException("called contains() with a null key");
        return get(key) != null;
    }

    public V get(K key) {
        return get(root,key);
    }

    private V get(Node x, K key){
        if(key == null) throw new IllegalArgumentException("called get() with a null key");

        //if(x == null) return null;
        /*int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left,key);
        else if (cmp > 0) return get(x.right,key);
        else
            return x.val;*/

        while(x != null) {
            int cmp = key.compareTo(x.key);

            if(cmp > 0) {
                x = x.right;
            } else if(cmp < 0) {
                x = x.left;
            } else {
                System.out.println("Key - "+x.key+" ,Val - "+x.val+" ,Size - "+x.size);
                return x.val;
            }
        }

        return null;
    }

    public void put(K key,V val) {
        if(key == null) throw new IllegalArgumentException("called put() with a null key");

        if(val == null) {
            delete(key);
            return;
        }

        root = put(root,key,val);
    }

    public Node put(Node x,K key, V val) {
        if(x == null) return new Node(key,val,1);
      /*  Node temp = x,parent = null;
        while(temp != null) {
            parent = temp;
            int cmp = key.compareTo(temp.key);
            if(cmp < 0) {
                temp.size = temp.size + 1;
                temp = temp.left;
            } else if(cmp > 0) {
                temp.size = temp.size + 1;
                temp = temp.right;
            } else {
                temp.val = val;
                return x;
            }
        }

        Node n = new Node(key,val,1);
        int cmp = key.compareTo(parent.key);
        if(cmp < 0) {
            parent.left = n;
        } else {
            parent.right = n;
        } */

        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left,key,val);
        else if(cmp > 0)x.right = put(x.right,key,val);
        else x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
       /* System.out.println("Key - "+x.key+" ,Val - "+x.val+" ,Size - "+x.size);*/
        return x;
    }

    public void deleteMin() {
        if(isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if(isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("called delete() with a null key");
        root = delete(root, key);
        assert check();
    }

    private Node delete(Node x,K key){
        if(x==null) return null;

        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left,key);
        else if(cmp > 0) x.right = delete(x.right,key);
        else {
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }





    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public K min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public K max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else                 return max(x.right);
    }

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public K floor(K key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    /**
     * Returns the smallest key in the symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in the symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public K ceiling(K key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }
        return ceiling(x.right, key);
    }

    /**
     * Return the kth smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the {@code k}th smallest key in the symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public K select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(x.left,  k);
        else if (t < k) return select(x.right, k-t-1);
        else            return x;
    }

    /**
     * Return the number of keys in the symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(K key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    // Number of keys in the subtree less than key.
    private int rank(K key, Node x) {
        if (x == null) return 0;
        int rank = 0;
        while(x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) {
                x = x.left;
            } else if(cmp > 0) {
                rank = rank + 1 + size(x.left);
                x = x.right;
            } else {
                return size(x.left) + rank;
            }
        }

        return 0;
       /* int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);*/
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (K key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<K> keys() {
        return keys(min(), max());
    }

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<K> keys(K lo, K hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<K> queue = new Queue<K>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<K> queue, K lo, K hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
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
    public int size(K lo, K hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }

    /**
     * Returns the height of the BST (for debugging).
     *
     * @return the height of the BST (a 1-node tree has height 0)
     */
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /**
     * Returns the keys in the BST in level order (for debugging).
     *
     * @return the keys in the BST in level order traversal
     */
    public Iterable<K> levelOrder() {
        Queue<K> keys = new Queue<K>();
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

    /*************************************************************************
     *  Check integrity of BST data structure.
     ***************************************************************************/
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
    private boolean isBST(Node x, K min, K max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (K key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }

    /**
     * Unit tests the {@code BST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        BST<String, Integer> st = new BST<String, Integer>();
        String[] a = new String[] {"S","E","A" ,"R","C","H","E","X","A","M","P","L","E"};
       /* String[] a = new String[] {"S","E","A"};*/
        for (int i = 0; i < a.length; i++) {
            String key = a[i];
            st.put(key, i);
        }

      /*  for (String s : st.levelOrder())
            StdOut.println(s + " " + st.get(s));

        StdOut.println();
*/

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));

        System.out.println("Celling of N" +
                " - "+st.ceiling("N"));
        System.out.println("Floor of N - "+st.floor("N"));
        System.out.println("Rank of M - "+st.rank("M"));
    }


}
