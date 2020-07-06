package com.java.algorithm.tree.trie;

import com.java.stdlib.StdOut;

import java.util.*;

public class Trie {
    private boolean isLaaf;
    private Map<Character,Trie> children;

    public Trie() {
        isLaaf = false;
        children = new HashMap<>();
    }

    public boolean isLaaf() {
        return isLaaf;
    }

    public void setLaaf(boolean laaf) {
        isLaaf = laaf;
    }

    public Map<Character, Trie> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, Trie> children) {
        this.children = children;
    }

    public void insert(String key) {
        Trie curr = this;
        Trie prev = null;
        for(char c : key.toCharArray()) {
            curr.children.putIfAbsent(c,new Trie());
            prev = curr;
            prev.isLaaf = false;
            curr = curr.children.get(c);
        }


        curr.isLaaf = true;
    }

    public boolean delete(String key) {
        Trie curr = this;
        return deleteHelper(curr,key,0);
    }

    private boolean deleteHelper(Trie curr,String key, int level) {

        if(curr == null) {
            return false;
        }

        if(key.length() == level) {
            if(!curr.isLaaf) {
                return false;
            }

            //curr.isLaaf = false;
            return curr.getChildren().size() == 0;

        } else {
            Trie child = curr.children.get(key.charAt(level));
            boolean canDeleteChild = deleteHelper(child,key,level + 1);

            if(canDeleteChild) {
                curr.getChildren().remove(key.charAt(level));
                return curr.getChildren().size() == 0;
            }

        }

        return true;
    }

    public boolean search(String key) {
        Trie curr = this;

        for(char c : key.toCharArray()) {

            curr = curr.children.get(c);

            if(curr == null)
                return false;

        }

        return curr.isLaaf;
    }

    public String longestCommonPrefix() {
        Trie curr = this;
        StringBuilder sb = new StringBuilder();
        while(curr != null && !curr.isLaaf
                && curr.getChildren().size() == 1) {

            for(Map.Entry<Character,Trie> entry : curr.getChildren().entrySet()) {
                sb.append(entry.getKey());
                curr = entry.getValue();
            }
        }

        return sb.toString();
    }

    public List<String> findAllWordsWithPrefix(String prefix) {
        Trie curr = this;
        for(char ch : prefix.toCharArray()) {
            curr = curr.getChildren().get(ch);
            if(curr == null) {
                return null;
            }
        }

        if(curr.isLaaf) {
            return Collections.singletonList(prefix);
        }

        // Now curr points to last char of prefix
        List<String> result = new ArrayList<>();
        findAllWords(curr,prefix,result);

        return result;
    }

    private void findAllWords(Trie curr,String path,List<String> result) {
        if(curr.isLaaf) {
            result.add(path);
            return;
        }

        for(Map.Entry<Character,Trie> entry : curr.getChildren().entrySet()) {
            findAllWords(entry.getValue(),path + entry.getKey(),result);
        }
    }

    public static void main(String[] args) {
        Trie root = new Trie();
        String[] words = {"mihir","saloni","kaavya","rohit","nita","anya", "aditya"};


        StdOut.println(root.search("kaavya"));

        StdOut.println(root.delete("kaavya"));

        StdOut.println(root.search("kaavya"));

        List<String> commonPrefix = Arrays.asList(
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codec", "codecs", "codependence", "codex", "codify",
                "codependents", "codes", "code", "coder", "codesign", "codec",
                "codeveloper", "codrive", "codec", "codecs", "codiscovered"
        );

        root = new Trie();

        for(String word : commonPrefix) {
            root.insert(word);
        }

        StdOut.println(root.longestCommonPrefix());

        StdOut.println(root.findAllWordsWithPrefix("code"));


    }

}
