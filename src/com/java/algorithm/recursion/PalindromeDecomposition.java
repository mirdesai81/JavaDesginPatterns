package com.java.algorithm.recursion;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.List;

public class PalindromeDecomposition {

    public static List<List<String>> palindromePartitioning(String input) {
        List<List<String>> result = new ArrayList<>();
        directedPalindromePartitioning(input,0,new ArrayList<String>(),result);
        return result;
    }

    private static void directedPalindromePartitioning(String input,int offset,List<String> partialPartition,List<List<String>> result) {
        if(offset == input.length()) {
            result.add(new ArrayList<>(partialPartition));
            return;
        }

        for(int i = offset + 1; i <= input.length(); i++) {
            String prefix = input.substring(offset,i);
            if(isPalindrome(prefix)) {
                partialPartition.add(prefix);
                directedPalindromePartitioning(input,i,partialPartition,result);
                partialPartition.remove(partialPartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++ , --j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "0204451881";
        StdOut.println(palindromePartitioning(input));
    }
}
