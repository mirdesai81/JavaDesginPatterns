package com.java.algorithm.educative.strings;

public class LongestCommonSubString {

    public static int findLCSLength(String s1,String s2) {
        //return findLCSLength(s1,s2,0,0,0);
        //return findLCSLength(new Integer[s1.length()][s2.length()][Math.min(s1.length(),s2.length())],s1,s2,0,0,0);

        return findLCSLength(new int[s1.length() + 1][s2.length() + 1],s1,s2);
    }

    public static int findLCSLength(int[][] dp,String s1,String s2) {
        int maxLength = 0;
        for(int startIdx = 1;startIdx <= s1.length();startIdx++) {
            for(int endIdx = 1; endIdx <= s2.length();endIdx++) {
                if(s1.charAt(startIdx - 1) == s2.charAt(endIdx - 1)) {
                    dp[startIdx][endIdx] = 1 + dp[startIdx - 1][endIdx - 1];
                    maxLength = Math.max(maxLength,dp[startIdx][endIdx]);
                }
            }
        }

        return maxLength;
    }

    public static int findLCSLength(String s1, String s2,int i1,int i2,int count) {
        if(i1 == s1.length() || i2 == s2.length()) return count;

        if(s1.charAt(i1) == s2.charAt(i2)) {
            count = findLCSLength(s1,s2,i1 + 1,i2 + 1,count + 1);
        }

        int c1 = findLCSLength(s1,s2,i1 + 1,i2,0);
        int c2 = findLCSLength(s1,s2,i1,i2 + 1,0);
        return Math.max(count,Math.max(c1,c2));
    }

    public static int findLCSLength(Integer[][][] dp,String s1,String s2,int i1,int i2,int count) {
        if(i1 == s1.length() || i2 == s2.length()) return count;

        if(dp[i1][i2][count] == null) {
            int c1 = count;
            if(s1.charAt(i1) == s2.charAt(i2)) {
                c1 = findLCSLength(dp,s1,s2,i1 + 1, i2 + 1,count + 1);
            }

            int c2 = findLCSLength(dp,s1,s2,i1 + 1,i2,0);
            int c3 = findLCSLength(dp,s1,s2,i1,i2 + 1,0);
            dp[i1][i2][count] = Math.max(c1,Math.max(c2,c3));
        }

        return dp[i1][i2][count];
    }

    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }
}
