package com.java.algorithm.educative.trie;

import com.java.algorithm.educative.trie.base.Trie;
import com.java.algorithm.educative.trie.base.TrieNode;

import java.util.ArrayList;

class Sort {

    public static ArrayList<String> sortArray(String[] arr) {
        ArrayList<String> result = new ArrayList<String>();
        TrieNode root = buildTrie(arr);
        char[] str = new char[26];
        getWords(root,result,0,str);
        // add your code here

        return result;
    }

    public static void getWords(TrieNode root,ArrayList<String> result,int level,char[] str) {
        if(root.isEndWord) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < level; i++)
                sb.append(str[i]);

            result.add(sb.toString());
        }

        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                str[level] = (char)(i + 'a');
                getWords(root.children[i],result,level + 1,str);
            }
        }
    }

    public static TrieNode buildTrie(String[] arr) {
        Trie trie = new Trie();
        for(int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }

        return trie.getRoot();
    }
}