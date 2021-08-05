package com.java.algorithm.educative.trie;

import com.java.algorithm.educative.trie.base.Trie;
import com.java.algorithm.educative.trie.base.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;

//TrieNode => {TrieNode[] children, boolean isEndWord, int value,
//markAsLeaf(int val), unMarkAsLeaf()}
class TrieWords
{
    //Recursive Function to generate all words
    public static void getWords(TrieNode root, ArrayList < String > result, int level, char[] str)
    {
        // use this as helper function
        if(root.isEndWord) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < level; i++) {
                sb.append(str[i]);
            }

            result.add(sb.toString());
        }

        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                // set the value for latter retrival
                str[level] = (char)( i + 'a');
                getWords(root.children[i],result,level + 1,str);
            }
        }

    }
    public static ArrayList< String > findWords(TrieNode root)
    {
        ArrayList < String > result = new ArrayList < String > ();
        char[] str = new char[26];
        getWords(root,result,0,str);
        // write your code here
        return result;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList < String > list = findWords(t.getRoot());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}