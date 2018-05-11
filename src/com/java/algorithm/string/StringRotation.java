package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/10/2018.
 */
public class StringRotation {

    public static boolean isStringRotation(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }

        if(s1.length() != s2.length()) {
            return false;
        }

        s1 = s1 + s1;

        // s2 is a substring of s1
        if(s1.contains(s2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isStringRotation("ABCD","CDAB"));
        System.out.println(isStringRotation("ABCD","CDBA"));
    }
}
