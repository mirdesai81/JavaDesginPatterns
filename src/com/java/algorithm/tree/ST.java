package com.java.algorithm.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * Created by Mihir.Desai on 4/25/2017.
 */
public class ST<K extends Comparable<K>,V> implements Iterable<K> {
    private TreeMap<K,V> st;

    public ST() {
        st = new TreeMap<>();
    }

    public V get(K key) {
        if(key == null) throw new IllegalArgumentException("called get() with null key");

        return st.get(key);
    }

    public void put(K key, V value) {
        if(key == null) throw new IllegalArgumentException("called put() with null key");
        if(value == null) st.remove(key);
        else
            st.put(key,value);
    }

    public void delete(K key) {
        if(key == null) throw new IllegalArgumentException("called delete() with null key");
        st.remove(key);
    }

    public boolean contains(K key) {
        if(key == null) throw new IllegalArgumentException("called contains() with null key");
        return st.containsKey(key);
    }

    public int size() { return st.size();}

    public boolean isEmpty() { return size() == 0;}

    public Iterable<K> keys() {
        return st.keySet();
    }

    @Override
    public Iterator<K> iterator() {
        return st.keySet().iterator();
    }

    public K min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return st.firstKey();
    }

    public K max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return st.lastKey();
    }

    /**
     * Returns the smallest key in this symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in this symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public K ceiling(K key) {
        if (key == null) throw new IllegalArgumentException("called ceiling() with null key");
        K k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    /**
     * Returns the largest key in this symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in this symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public K floor(K key) {
        if (key == null) throw new IllegalArgumentException("called floor() with null key");
        K k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    /**
     * Unit tests the {@code ST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();
        String[] a = new String[] {"Z","S","O","R","T","E","X","A","M","P","L","E","N","D"};
        for (int i = 0; i < a.length; i++) {
            String key = a[i];
            st.put(key, i);
        }
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }
}
