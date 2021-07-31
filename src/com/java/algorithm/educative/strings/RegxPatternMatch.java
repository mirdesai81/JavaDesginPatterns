package com.java.algorithm.educative.strings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegxPatternMatch{
    static boolean regxMatch(String text, String pattern) {
        //TODO: Write - Your - Code
        return regxMatch(text,pattern,text.length(),pattern.length());
    }

    static boolean regxMatch(String text,String pattern,int n, int m) {
        if(m == 0) return n == 0;
        boolean[][] lookup = new boolean[n + 1][m + 1];
        for(int i = 0; i <= n; i++) {
                Arrays.fill(lookup[i],false);
        }

        lookup[0][0] = true;

        for(int j = 1; j <= m; j++) {
            if(pattern.charAt(j - 1) == '*') {
                lookup[0][j] = true;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(pattern.charAt(j - 1) == '*') {
                    lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];
                } else if(pattern.charAt(j - 1) == '.' || text.charAt(i - 1) == pattern.charAt(j - 1)) {
                    lookup[i][j] = lookup[ i -1][j -1];
                } else {
                    lookup[i][j] = false;
                }
            }
        }

        return lookup[n][m];
    }


        static boolean regxMatchRec(String text, String pattern) {
            if (text.isEmpty() && pattern.isEmpty()) {
                return true;
            }

            if (!text.isEmpty() && pattern.isEmpty()) {
                return false;
            }

            if (pattern.length() > 1 && pattern.charAt(1) == '*') {

                String remainingPattern = pattern.substring(2);
                String remainingText = text;

                for (int i = 0; i < text.length() + 1; ++i) {
                    if (regxMatchRec(remainingText, remainingPattern)) {
                        return true;
                    }

                    if (remainingText.isEmpty()) {
                        return false;
                    }

                    if (pattern.charAt(0) != '.' &&
                            remainingText.charAt(0) != pattern.charAt(0)) {
                        return false;
                    }

                    remainingText = remainingText.substring(1);
                }
            }

            if (text.isEmpty() || pattern.isEmpty()) {
                return false;
            }

            if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
                String remainingText = "";
                if (text.length() >= 2) {
                    remainingText = text.substring(1);
                }

                String remainingPattern = "";
                if (pattern.length() >= 2) {
                    remainingPattern = pattern.substring(1);
                }

                return regxMatchRec(remainingText, remainingPattern);
            }

            return false;
        }



        public static void main(String[] args) {
            String s = "fabbbc";
            String p = ".ab*c";
            boolean output2 = regxMatch(s, p);

            Pattern pattern = Pattern.compile(p);
            Matcher matcher = pattern.matcher(s);

            if (output2) {
                System.out.print(s + " " + p + " match");
            } else {
                System.out.print(s + " " + p + " did not match.");
            }
        }


}