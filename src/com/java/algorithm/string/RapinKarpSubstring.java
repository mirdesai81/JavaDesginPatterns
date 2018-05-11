package com.java.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihir.Desai on 5/9/2018.
 */
public class RapinKarpSubstring {
    public static List<Integer> rabinKarp(String t, String s) {
        if(s.length() > t.length()) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        final int BASE = 26;
        int tHash = 0, sHash = 0;
        int powerS = 1;

        for(int i = 0; i < s.length();++i) {
            powerS = i > 0 ? powerS * BASE : 1;
            tHash = tHash * BASE + t.charAt(i);
            sHash = sHash * BASE + s.charAt(i);
            System.out.println("tHash - "+tHash+" ,sHash - "+sHash+" ,powerS - "+powerS);
        }

        for(int i = s.length(); i < t.length(); ++i) {
            if(tHash == sHash && t.substring(i - s.length(),i).equals(s)) {
                result.add(i - s.length());
                System.out.println("Found substring at index - "+(i - s.length()));
            }

            // uses rolling hash to compute the new hash code
            tHash -= t.charAt(i - s.length()) * powerS;
            tHash = tHash * BASE + t.charAt(i);
            System.out.println("tHash - "+tHash+" ,sHash - "+sHash+" ,powerS - "+powerS);
        }

        // tries to match s and t.substring(t.length() - s.length()).
        // last part of substring
        if(tHash == sHash && t.substring(t.length() - s.length()).equals(s)) {
            result.add(t.length() - s.length());
            System.out.println("Found substring at index - "+(t.length() - s.length()));
        }


        if(result.isEmpty()) {
            return null;
        }
        return result;
    }

    public static void main(String[] args) {
        String t = "GACGCCGCA";

        String s = "CGC";

        System.out.println(rabinKarp(t,s));
    }
}
