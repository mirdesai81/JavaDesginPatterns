package com.java.algorithm.educative.trie;

import com.java.algorithm.educative.trie.base.TrieNode;
import com.java.algorithm.educative.trie.base.Trie;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfWordsInTrie {


        public static int totalWords(TrieNode root){
            // Write - Your - Code
            Queue<TrieNode> q = new LinkedList<>();
            q.offer(root);
            TrieNode curr;
            int total = 0;
            while(!q.isEmpty()) {
                curr = q.poll();
                if(curr.isEndWord()) {
                    total = total + 1;
                }

                for(int i = 0; i < curr.children.length; i++) {
                    if(curr.children[i] != null) {
                        q.offer(curr.children[i]);
                    }
                }
            }

            return total;
        }




    public static int totalWordsRec(TrieNode root){
        int result = 0;

        // Leaf denotes end of a word
        if (root.isEndWord)
            result++;

        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                result += totalWords(root.children[i]);
        return result;
    }

    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie
        Trie t = new Trie();

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

      //  System.out.println(totalWords(t.getRoot()));

        System.out.println(totalWordsRec(t.getRoot()));
    }

}
