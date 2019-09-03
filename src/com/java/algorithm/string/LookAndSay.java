package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/8/2018.
 */
public class LookAndSay {
    public static String lookAndSay(int n) {
       String s = "1";

       for(int i = 0; i < n;i++) {
           s = nextNumber(s);
       }

       return s;
    }

    private static String nextNumber(String s) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int count = 1;
            while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                ++i;
                ++count;
            }
            result.append(count).append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(lookAndSay(7));
    }
}
