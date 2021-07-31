package com.java.algorithm.educative.strings;

public class LongestPalindromeSubSequence {
    private static int findLPSLength(String str) {
        return findLPSLength(new int[str.length()][str.length()] , str);
       // return findLPSLength(new Integer[str.length()][str.length()],str,0,str.length() - 1);
    }

    private static int findLPSLength(String str,int startIdx, int endIdx) {
        if(startIdx > endIdx) return 0;

        if(startIdx == endIdx) return 1;

        // include both and recur for remaining
        if(str.charAt(startIdx) == str.charAt(endIdx)) {
            return 2 + findLPSLength(str,startIdx + 1,endIdx - 1);
        }


        // case 2: skip one element either from the beginning or the end
        int c1 = findLPSLength(str,startIdx + 1,endIdx);
        int c2= findLPSLength(str,startIdx, endIdx - 1);
        return Math.max(c1,c2);
    }

    private static int findLPSLength(int[][] dp,String str) {

        // every sequence with one element is a palindrome of length 1
        for(int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }

        for(int startIdx = str.length() - 1; startIdx >= 0; startIdx--) {
            for(int endIdx = startIdx + 1; endIdx < str.length(); endIdx++) {
                // include both and recur for remaining
                if(str.charAt(startIdx) == str.charAt(endIdx)) {
                    dp[startIdx][endIdx] =  2 + dp[startIdx + 1][endIdx - 1];
                } else {
                    dp[startIdx][endIdx] = Math.max(dp[startIdx + 1][endIdx], dp[startIdx][endIdx  - 1]);
                }
            }
        }

        return dp[0][str.length() - 1];
    }

    private static int findLPSLength(Integer[][] dp,String str,int startIdx, int endIdx) {
        if(startIdx > endIdx) return 0;

        if(startIdx == endIdx) return 1;

        if(dp[startIdx][endIdx] == null) {
            if(str.charAt(startIdx) == str.charAt(endIdx)) {
                dp[startIdx][endIdx] = 2 + findLPSLength(dp,str,startIdx + 1,endIdx - 1);
            } else {
                // case 2: skip one element either from the beginning or the end
                int c1 = findLPSLength(dp,str,startIdx + 1,endIdx);
                int c2= findLPSLength(dp,str,startIdx, endIdx - 1);
                dp[startIdx][endIdx] = Math.max(c1,c2);
            }

        }

        return dp[startIdx][endIdx];
    }

    public static void main(String[] args) {
        LongestPalindromeSubSequence lps = new LongestPalindromeSubSequence();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
