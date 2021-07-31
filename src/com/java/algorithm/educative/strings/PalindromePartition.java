package com.java.algorithm.educative.strings;

public class PalindromePartition {

    public static int findMinimumPartitions(int[] cuts,boolean[][] isPalindrome,String st) {

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++)
            isPalindrome[i][i] = true;

        // populate isPalindrome table
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || isPalindrome[startIndex + 1][endIndex - 1]) {
                        isPalindrome[startIndex][endIndex] = true;
                    }
                }
            }
        }

        // now lets populate the second table, every index in 'cuts' stores the minimum cuts needed
        // for the substring from that index till the end
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            int minCuts = st.length(); // maximum cuts
            for (int endIndex = st.length() - 1; endIndex >= startIndex; endIndex--) {
                if (isPalindrome[startIndex][endIndex]) {
                    // we can cut here as we got a palindrome
                    // also we dont need any cut if the whole substring is a palindrome
                    minCuts = (endIndex == st.length() - 1) ? 0 : Math.min(minCuts, 1 + cuts[endIndex + 1]);
                }
            }
            cuts[startIndex] = minCuts;
        }

        return cuts[0];
    }

    public static int findMinimumPartitions(String str) {
        Integer dp[][] = new Integer[str.length()][str.length()];
        Boolean dpIsPalindrome[][] = new Boolean[str.length()][str.length()];
        //return findMinimumPartitions(str,0,str.length() - 1);
        //return findMinimumPartitions(dp,dpIsPalindrome,str,0,str.length() - 1);

        return findMinimumPartitions(new int[str.length()],new boolean[str.length()][str.length()],str);
    }

    public static int findMinimumPartitions(String str,int startIdx,int endIdx) {
        if(startIdx >= endIdx || isPalindrome(str,startIdx,endIdx)) {
            return 0;
        }

        int min = endIdx - startIdx;
        for(int i = startIdx; i <= endIdx; i++) {
            if(isPalindrome(str,startIdx,i)) {
                min = Math.min(min,1 + findMinimumPartitions(str,i + 1,endIdx));
            }
        }

        return min;
    }

    public static int findMinimumPartitions(Integer[][] dp, Boolean[][] dpIsPalindrome,String str,int startIdx,int endIdx) {
        if(startIdx >= endIdx || isPalindrome(dpIsPalindrome,str,startIdx,endIdx)) {
            return 0;
        }

        if(dp[startIdx][endIdx] == null) {
            int min = endIdx - startIdx;
            for (int i = startIdx; i <= endIdx; i++) {
                if (isPalindrome(dpIsPalindrome, str, startIdx, i)) {
                    min = Math.min(min, 1 + findMinimumPartitions(dp,dpIsPalindrome,str, i + 1, endIdx));
                }
            }
            dp[startIdx][endIdx] = min;
        }

        return dp[startIdx][endIdx];
    }

    public static boolean isPalindrome(Boolean[][] dpIsPalindrome,String str,int startIdx,int endIdx) {

        if(dpIsPalindrome[startIdx][endIdx] == null) {
            dpIsPalindrome[startIdx][endIdx] = true;
            int x = startIdx, y= endIdx;
            while(x < y) {
                if(str.charAt(x++) != str.charAt(y--)) {
                    dpIsPalindrome[startIdx][endIdx] = false;
                    break;
                }
                if(x < y && dpIsPalindrome[x][y] != null) {
                    dpIsPalindrome[startIdx][endIdx] = dpIsPalindrome[x][y];
                    break;
                }

            }
        }

        return dpIsPalindrome[startIdx][endIdx];

    }

    public static boolean isPalindrome(String str,int startIdx,int endIdx) {
        while(startIdx < endIdx) {
            if(str.charAt(startIdx) != str.charAt(endIdx)) {
                return false;
            }
            startIdx++;
            endIdx--;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(findMinimumPartitions("abdbca"));
        System.out.println( findMinimumPartitions("cddpd"));
        System.out.println(findMinimumPartitions("pqr"));
        System.out.println(findMinimumPartitions("abba"));
    }
}
