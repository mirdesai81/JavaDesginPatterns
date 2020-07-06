package com.java.algorithm.tree.trie;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakProblem {

    /**
     * This algo find all possible combination of word break from given dictionary of words
     * @param dict
     * @param str
     * @param out
     * @param result
     */
    public static void wordBreak(List<String> dict,String str,String out,List<String> result) {
        if(str.length() == 0) {
            result.add(out);
        }

        for(int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0,i);
            if(dict.contains(prefix)) {
                wordBreak(dict,str.substring(i),out + " " + prefix,result);
            }
        }
    }

    public static boolean wordBreak(Trie root,String str) {
        boolean[] memo = new boolean[str.length() + 1];
        Arrays.fill(memo,false);
        memo[0] = true;


        for(int i = 0; i < str.length(); i++) {
            if(memo[i]) {
                Trie curr = root;
                for(int j = i; j < str.length(); j++) {
                    if(curr == null) {
                        break;
                    }

                    curr = curr.getChildren().get(str.charAt(j));
                    // We can segment from [0,i]
                    // and [i + 1, j] using the string in trie
                    if(curr != null && curr.isLaaf()) {
                        memo[j + 1] = true;
                    }

                }
            }
        }

        return memo[str.length()];
    }

    /**
     * This Algo uses recursion
     * @param dict
     * @param str
     * @return
     */
    public static boolean wordBreak(List<String> dict,String str) {
        if(str.length() == 0) {
            return true;
        }

        for(int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0,i);
            if(dict.contains(prefix) && wordBreak(dict,str.substring(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * This Algo uses Dynamic Programming
     * @param dict
     * @param str
     * @param lookup
     * @return
     */
    public static boolean wordBreak(List<String> dict,String str,int[] lookup) {
        int n = str.length();

        if(n == 0) {
            return true;
        }

        if(lookup[n] == -1) {
            lookup[n] = 0;
            for (int i = 1; i <= n; i++) {
                if(dict.contains(str.substring(0,i))
                        && wordBreak(dict,str.substring(i),lookup)) {
                    lookup[i] = 1;
                    return true;
                }
            }
        }

        return lookup[n] == 1;
    }

    public static void main(String[] args) {
        // List of Strings to represent dictionary
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
                "Word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "problem");

        // input String
        String str = "Wordbreakproblem";

        Trie root = new Trie();

        for(String word : dict) {
            root.insert(word);
        }

        if (wordBreak(dict, str)) {
            System.out.println("String can be segmented");
        } else {
            System.out.println("String can't be segmented");
        }

        List<String> result = new ArrayList<>();
        wordBreak(dict,str,"",result);

        StdOut.println(result);

        int[] lookup = new int[str.length() + 1];
        Arrays.fill(lookup, -1);
        if (wordBreak(dict, str,lookup)) {
            System.out.println("String can be segmented");
        } else {
            System.out.println("String can't be segmented");
        }

        StdOut.println(wordBreak(root,str));
    }


}
