package com.java.algorithm.recursion;

import com.java.stdlib.StdOut;

public class CheckPalindrome {
    public static boolean checkPalindrome(String str) {
        if(str.length() == 1 || str.length() == 0) {
            return true;
        }

        if(str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        return (str.charAt(0) == str.charAt(str.length() - 1)) && checkPalindrome(str.substring(1,str.length() - 1));
    }

    public static void main(String[] args){
        String str = "abcdba";
        StdOut.println(checkPalindrome(str));
    }
}
