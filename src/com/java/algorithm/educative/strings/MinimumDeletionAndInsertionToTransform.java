package com.java.algorithm.educative.strings;

public class MinimumDeletionAndInsertionToTransform {



        public void findMDI(String s1, String s2) {
            // TODO: Write your code here
            int c1 = findLCSLength(new int[s1.length() + 1][s2.length() + 1],s1,s2);
            System.out.println("Minimum deletions needed: " + (s1.length() - c1));
            System.out.println("Minimum insertions needed: " + (s2.length() - c1));
        }

        public int findLCSLength(int[][] dp,String s1,String s2) {
            int maxLength = 0;
            for(int i = 1; i <= s1.length(); i++) {
                for(int j = 1; j <= s2.length(); j++) {
                    if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i -1][j - 1];
                    } else {
                        int c1 = dp[i - 1][j];
                        int c2 = dp[i][j - 1];
                        dp[i][j] = Math.max(c1 , c2);
                    }

                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }

            return maxLength;
        }


        public static void main(String[] args) {
            MinimumDeletionAndInsertionToTransform mdi = new MinimumDeletionAndInsertionToTransform();
            mdi.findMDI("abc", "fbc");
            mdi.findMDI("abdca", "cbda");
            mdi.findMDI("passport", "ppsspt");
        }

}
