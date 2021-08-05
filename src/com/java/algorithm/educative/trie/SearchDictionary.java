package com.java.algorithm.educative.trie;

import com.java.algorithm.educative.trie.base.Trie;
import com.java.algorithm.educative.trie.base.TrieNode;

import java.util.Arrays;

public class SearchDictionary {

        public static boolean isFormationPossible(String[] dict,String word) {
            // write your code here
            if(word.length() < 2 || dict.length < 2 ) return false;

            Trie trie = new Trie();

            for(int i = 0; i < dict.length; i++) {
                trie.insert(dict[i]);
            }

            for(int i = 0; i < word.length(); i++) {
                String first = word.substring(0,i);
                String second = word.substring(i,word.length());

                if(search(trie.getRoot(),first) && search(trie.getRoot(),second)) return true;
            }

            return false;
        }

        public static boolean search(TrieNode root, String s) {
            if(s == null || s.length() == 0) return false;
            int index = 0;
            for(int i = 0; i < s.length(); i++) {
                index = getIndex(s.charAt(i));
                TrieNode node = root.children[index];
                if(node == null) return false;
                root = root.children[index];
            }

            if(root.isEndWord) return true;

            return false;
        }

        public static int getIndex(char t) {
            return t - 'a';
        }


    public static void main(String args[]){
        // Input dict (use only 'a' through 'z' and lower case)
        String dict[] = {"the", "hello", "there", "answer","any", "dragon", "world", "their",  "inc"};

        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(dict));

        if(isFormationPossible(dict, "helloworld"))
            System.out.println("true");
        else
            System.out.println("false");

    }

}
