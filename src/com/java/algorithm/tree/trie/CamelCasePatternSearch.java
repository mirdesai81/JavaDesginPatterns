package com.java.algorithm.tree.trie;

import com.java.stdlib.StdOut;

import java.util.*;

public class CamelCasePatternSearch {

    private static class TrieNode {
        boolean isLeaf;
        Map<Character,TrieNode> children;
        Set<String> words;

        public TrieNode() {
            isLeaf = false;
            children = new HashMap<>();
            words = new HashSet<>();
        }

        public void insert(String str) {
            TrieNode curr = this;

            for(char ch : str.toCharArray()) {
                if(Character.isUpperCase(ch)) {
                    curr.children.putIfAbsent(ch, new TrieNode());
                    curr = curr.children.get(ch);
                }
            }

            curr.isLeaf = true;
            curr.words.add(str);
        }

        public void printAll() {
            TrieNode curr = this;

            Stack<TrieNode> stack = new Stack<>();
            stack.push(curr);

            while(!stack.isEmpty()) {
                curr = stack.pop();
                if(curr != null) {
                    if(curr.isLeaf) {
                        StdOut.println(curr.words);
                    } else {
                        for(Map.Entry<Character,TrieNode> children : curr.children.entrySet()) {
                            stack.push(children.getValue());
                        }
                    }
                }
            }
        }

    }

    public static boolean patternMatch(List<String> dict,String str) {
        TrieNode root = new TrieNode();
        for(String word : dict)
            root.insert(word);

        TrieNode curr = root;

        for(char ch : str.toCharArray()) {
            curr = curr.children.get(ch);
            if(curr == null) {
                return false;
            }
        }

        curr.printAll();
        return true;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("SaloniDesai","ShitalDesai","MihirDesai","MinalDesai","KaavyaDesai","RohitDesai");
        patternMatch(dict,"MD");
    }

}
