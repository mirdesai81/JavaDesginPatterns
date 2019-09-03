package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/10/2018.
 */
public class LongestSubStringWithNonRepeating {
    public static int SubstrNonRepeating(String str) {
        int max = 1;
        int start = 0;
        String longestSoFar = "" + str.charAt(0);
        String result = "" + str.charAt(0);


        // start from 1 to str.length
        for(int i = 1; i < str.length();i++) {

            for(int j = start; j < i; j++) {
                if(str.charAt(i) == str.charAt(j)) {

                    if(longestSoFar.length() > result.length()) {
                        result = longestSoFar;
                    }

                    longestSoFar = longestSoFar.substring(longestSoFar.indexOf(str.charAt(j)) + 1);
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
        System.out.println("longest substring without repeating charactes -"+result);
        return max;
    }

    public static void main(String[] args) {
        /*System.out.println(SubstrNonRepeating("abcdbc"));*/

        System.out.println(SubstrNonRepeating("abacdbcae"));
    }
}
