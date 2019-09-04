package com.java.algorithm.hashtable;

import java.util.ArrayList;

public class Map<K,V> {

    private static class HashNode<K,V> {
        K key;
        V value;

        HashNode<K,V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public Map() {
        this(10);
    }

    public Map(int capacity) {
        numberOfBuckets = capacity;
        size = 0;
        bucketArray = new ArrayList<>(numberOfBuckets);

        for(int i = 0; i < numberOfBuckets; i++) {
            bucketArray.add(null);
        }
    }



    private int numberOfBuckets;
    private int size;
    private ArrayList<HashNode<K,V>> bucketArray;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getBucketIndex(K key) {
        // int hash = (((area * R + exch) % M) * R + ext) % M;  // US Phone numbers R = 31
        // int hash = 0;
        //for (int i = 0; i < s.length(); i++)
        //    hash = (R * hash + s.charAt(i)) % M;   // for String
        return (key.hashCode() & 0x7fffffff) % numberOfBuckets;
    }

    private void resize(int capacity) {
        ArrayList<HashNode<K,V>> temp = bucketArray;
        numberOfBuckets = capacity;
        bucketArray = new ArrayList<>();
        for(int i = 0; i < numberOfBuckets; i++) {
            bucketArray.add(null);
        }

        for(HashNode<K,V> headNode : temp) {
            while(headNode != null) {
                put(headNode.key,headNode.value);
                headNode = headNode.next;
            }
        }

    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public void put(K key, V value) {

        if(key == null) throw new IllegalArgumentException("Key cannot be null");

        if(value == null) {
            remove(key);
            return;
        }

        int bucketIndex = getBucketIndex(key);
        HashNode<K,V> head = bucketArray.get(bucketIndex);

        while(head != null) {
            if(key.equals(head.key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        HashNode<K,V> newNode = new HashNode<>(key,value);
        head = bucketArray.get(bucketIndex);
        newNode.next = head;
        bucketArray.set(bucketIndex,newNode);

        // resize the bucketArray if load factor is half full
        if (size >= numberOfBuckets/2) {
            resize(2 * numberOfBuckets);
        }
    }

    public V remove(K key) {
        if(key == null) throw new IllegalArgumentException("Key cannot be null");

        if(!contains(key)) return null;

        int bucketIndex = getBucketIndex(key);
        HashNode<K,V> head = bucketArray.get(bucketIndex);

        HashNode<K,V> prev = null;

        while(head != null) {
            if(head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        // head is null means no key found
        if(head == null) {
            return null;
        }


        size--;
        if(prev != null) {
            prev.next = head.next;
        } else { // if prev is null means first node is to be removed
            bucketArray.set(bucketIndex,head.next);
        }

        return head.value;
    }

    public V get(K key) {
        if(key == null) throw new IllegalArgumentException("Key cannot be null");
        int bucketIndex = getBucketIndex(key);
        HashNode<K,V> head = bucketArray.get(bucketIndex);

        while(head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }

            head = head.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Map<String, Integer>map = new Map<>();
        map.put("this",1 );
        map.put("coder",2 );
        map.put("this",4 );
        map.put("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }

}
