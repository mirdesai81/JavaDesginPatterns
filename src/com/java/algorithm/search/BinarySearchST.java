package com.java.algorithm.search;

import com.java.algorithm.queue.Queue;
import com.java.stdlib.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by Mihir.Desai on 4/26/2017.
 */
public class BinarySearchST<K extends Comparable<K>,V> {
    private K[] keys;
    private V[] vals;
    private int n = 0;
    private static final int INT_CAPACITY = 2;

    public BinarySearchST() {
        this(INT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        vals = (V[]) new Object[capacity];
    }

    private void resize(int capacity) {
        assert capacity >= n;
        K[] tempK = (K[]) new Comparable[capacity];
        V[] tempV = (V[]) new Object[capacity];

        for(int i = 0; i < n;i++) {
            tempK[i] = keys[i];
            tempV[i] = vals[i];
        }

        keys = tempK;
        vals = tempV;

    }

    public int size() { return n;}

    public boolean isEmpty() {return size() == 0;}


    /**
     * Find the rank of the key using binary search
     * @param key
     * @return index of Key in keys array
     */
    public int rank(K key) {
        if(key == null) throw new IllegalArgumentException("called rank() with null key");

        int lo = 0; int hi = n -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) {
                hi = mid -1;
            } else if(cmp > 0) {
                lo = mid + 1;
            } else {
              return mid;
            }
        }

        return lo;
    }

    public boolean contains(K key) {
        if(key == null) throw new IllegalArgumentException("called contains() with null key");
        return get(key) != null;
    }

    private boolean containsKeyAtIndex(K key, int i) {
        return keys[i].compareTo(key) == 0;
    }

    public V get(K key) {
        if(key == null) throw new IllegalArgumentException("called get() with null key");
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < n && containsKeyAtIndex(key,i)) return vals[i];
        return null;
    }

    public void put(K key,V val) {
        if(key == null) throw new IllegalArgumentException("called put() with null key");

        if(val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        // if key is already in table then replace value
        if(i < n && containsKeyAtIndex(key,i)) { vals[i] = val; return;}

        //resize
        if(n == keys.length) resize(2*keys.length);
        // right shift
        for(int j = n; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }

        keys[i] = key;
        vals[i] = val;
        n++;

    }

    public void delete(K key) {
        if(key == null) throw new IllegalArgumentException("called delete() with null key");
        if(isEmpty()) return;
        int i = rank(key);

        // key not in table
        if(i == n || !containsKeyAtIndex(key,i)) {
            return;
        }

        for(int j = i; j < n;j++){
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        keys[n] = null;
        vals[n] = null;

        // check the size
        if(n > 0 && n == keys.length/4) resize(keys.length/2);

    }

    public K min() {
        if(isEmpty()) throw new NoSuchElementException("called min() on empty symbol table");

        return keys[0];
    }

    public K max() {
        if(isEmpty()) throw new NoSuchElementException("called min() on empty symbol table");
        return keys[n-1];
    }

    public void deleteMin() {
        if(isEmpty()) throw new NoSuchElementException("symbol table underflow error");
        delete(min());
    }

    public void deleteMax() {
        if(isEmpty()) throw new NoSuchElementException("symbol table underflow error");
        delete(max());
    }

    public K select(int key) {
        if(key < 0 || key >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: "+key);
        }
        return keys[key];
    }

    /**
     * Return largest key in this ST less than or equal to {@code key}.
     * @return largest key
     */
    public K floor(K key) {
        if(key == null) throw new IllegalArgumentException("called delete() with null key");
        int i = rank(key);
        if(i < n && containsKeyAtIndex(key,i)) return keys[i];
        if(i == 0) return null;
        return keys[i-1];
    }


    /**
     * Return smallest key in this ST greater than or equal to {@code key}.
     * @return smallest key greated than or equal to {@code key}
     */
    public K ceiling(K key) {
        if(key == null) throw new IllegalArgumentException("called ceiling() with null key");
        int i = rank(key);
        if(i == n) return null;
        return keys[i];
    }

    /**
     * Returns the number of keys in this symbol table in the specified range.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return the number of keys in this symbol table between {@code lo}
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
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (K key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<K> keys() {
        return keys(min(), max());
    }

    /**
     * Returns all keys in this symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return all keys in this symbol table between {@code lo}
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<K> keys(K lo, K hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<K> queue = new Queue<K>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }


    /***************************************************************************
     *  Check internal invariants.
     ***************************************************************************/

    private boolean check() {
        return isSorted() && rankCheck();
    }

    // are the items in the array in ascending order?
    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }

    // check that rank(select(i)) = i
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }

    /**
     * Unit tests the {@code BinarySearchST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        String[] a = new String[] {"S","O","R","T","E","A","M","P","L","E"};
        for (int i = 0; i < a.length; i++) {
            String key = a[i];
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
