package com.java.algorithm.educative.strings;

public class PalindromeSubStringsCount {



        private static int findSubStringsCount(String str) {


            return findSubStringsCount(new boolean[str.length()][str.length()],str);
        }

       /* private static int findSubStringsCount(String str,int startIdx,int endIdx) {
            if(startIdx > endIdx ) return 0;

            if(startIdx == endIdx) return 1;

            if(str.charAt(startIdx) == str.charAt(endIdx)) {
                int remaining = endIdx - startIdx - 1;
                if(remaining == findLPSLength(str,startIdx + 1, endIdx - 1)) {
                    return 2 + remaining;
                }
            }
            // include either startIdx or endIdx
            int c1 = findLPSLength(str,startIdx + 1,endIdx);
            int c2 = findLPSLength(str,startIdx,endIdx - 1);
            return Math.max(c1,c2);
        }

        private static int findSubStringsCount(Integer[][] dp,String str,int startIdx,int endIdx) {
            if(startIdx > endIdx ) return 0;

            if(startIdx == endIdx) return 1;

            if(dp[startIdx][endIdx] == null) {
                if (str.charAt(startIdx) == str.charAt(endIdx)) {
                    int remaining = endIdx - startIdx - 1;
                    if (remaining == findSubStringsCount(str, startIdx + 1, endIdx - 1)) {
                        dp[startIdx][endIdx] =  2 + remaining;
                        return dp[startIdx][endIdx];
                    }
                }
                // include either startIdx or endIdx
                int c1 = findSubStringsCount(dp,str, startIdx + 1, endIdx);
                int c2 = findSubStringsCount(dp,str, startIdx, endIdx - 1);
                dp[startIdx][endIdx] = Math.max(c1, c2);
            }

            return dp[startIdx][endIdx];
        }
*/
        public static int findSubStringsCount(boolean[][] dp,String st) {
            // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
            // palindrome

            int count = 0;

            // every string with one character is a palindrome
            for (int i = 0; i < st.length(); i++) {
                dp[i][i] = true;
                count++;
            }


            for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
                for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                    if (st.charAt(startIndex) == st.charAt(endIndex)) {
                        // if it's a two character string or if the remaining string is a palindrome too
                        if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                            dp[startIndex][endIndex] = true;
                            count++;
                        }
                    }
                }
            }

            return count;
        }



        public static void main(String[] args) {
            PalindromeSubStringsCount palindromeSubStringsCount = new PalindromeSubStringsCount();
            System.out.println(palindromeSubStringsCount.findSubStringsCount("abdbca"));
            System.out.println(palindromeSubStringsCount.findSubStringsCount("cddpd"));
            System.out.println(palindromeSubStringsCount.findSubStringsCount("pqr"));
        }


}
