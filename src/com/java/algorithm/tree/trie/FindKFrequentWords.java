package com.java.algorithm.tree.trie;

import com.java.stdlib.StdOut;

import java.util.*;

public class FindKFrequentWords {

    private static class TrieNode {
        boolean isLeaf;
        Map<Character,TrieNode> children;
        String key;
        int count;

        public TrieNode() {
            isLeaf = false;
            children = new HashMap<>();
            count = 0;
        }


        public void insert(String key) {
            TrieNode curr = this;
            for(char ch : key.toCharArray()) {
                curr.children.putIfAbsent(ch,new TrieNode());
                curr = curr.children.get(ch);
            }

            curr.isLeaf = true;
            curr.key = key;
            curr.count += 1;
        }

    }

    private static class Entry implements Comparable {
        String key;
        int count;

        public Entry(String key, int count) {
            this.key = key;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {

            return Integer.compare(this.count,((Entry)o).count);
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key='" + key + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    private static PriorityQueue<Entry> DFS(TrieNode root,int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(Comparator.comparingInt(Entry::getCount));

        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        TrieNode curr;

        while(!stack.isEmpty()) {
            curr = stack.pop();

            if(curr.count != 0) {
                pq.add(new Entry(curr.key,curr.count));

                if(pq.size() > k) {
                    pq.poll();
                }

            }

            for (Map.Entry<Character, TrieNode> children : curr.children.entrySet()) {
                stack.push(children.getValue());
            }
        }

        return pq;

    }

    private static Entry DFS(TrieNode root) {
        Entry max = null;
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        TrieNode curr;

        while(!stack.isEmpty()) {
            curr = stack.pop();
            if(curr.count != 0) {
                if(max == null || curr.count > max.count) {
                    max = new Entry(curr.key,curr.count);
                }
            }

            for (Map.Entry<Character, TrieNode> children : curr.children.entrySet()) {
                stack.push(children.getValue());
            }

        }

        return max;
    }

    public static void findKFrequentWords(List<String> words,int k) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            root.insert(word);
        }

        PriorityQueue<Entry> pq = DFS(root,k);

        StdOut.println(pq);

    }

    public static void findMaxFrequentWord(List<String> words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            root.insert(word);
        }

        Entry max = DFS(root);

        StdOut.println(max);
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codec", "codecs", "codependence", "codex", "codify",
                "codependents", "codes", "code", "coder", "codesign", "codec",
                "codeveloper", "codrive", "codec", "codecs", "codiscovered"
        );

        int k = 4;

        findKFrequentWords(words, k);

        findMaxFrequentWord(words);
    }

}
