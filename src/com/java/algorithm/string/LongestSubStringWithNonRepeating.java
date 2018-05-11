package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/10/2018.
 */
public class LongestSubStringWithNonRepeating {
    public static int SubstrNonRepeating(String str) {
        int start = 0;
        int max = 1;
        String longestSoFar = "" + str.charAt(0);
        String result = "" + str.charAt(0);
        for(int i = 1; i < str.length();++i) {

            for(int j = start; j < i; ++j) {
                char c = str.charAt(j);
                char o = str.charAt(i);
                if(o == c) {
                    if(longestSoFar.length() > result.length()) {
                        result = longestSoFar;
                    }
                    longestSoFar = longestSoFar.substring(longestSoFar.indexOf(o) + 1);
                    System.out.println("longest - "+longestSoFar+" result - "+result);
                    start = j + 1;
                    break;
                }
            }

            longestSoFar = longestSoFar + str.charAt(i);
            if(longestSoFar.length() > result.length()) {
                result = longestSoFar;
            }
            max = Math.max(max,result.length());
        }

        System.out.println("longest substring with non repeating character - "+result);
        return max;
    }

    public static void main(String[] args) {
        /*System.out.println(SubstrNonRepeating("abcdbc"));*/

        System.out.println(SubstrNonRepeating("abacdbcae"));
    }
}
