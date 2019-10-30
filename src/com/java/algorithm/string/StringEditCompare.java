package com.java.algorithm.string;

import com.java.stdlib.StdOut;

public class StringEditCompare {
    public static boolean checkOneEdit(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(Math.abs(m - n) > 1) {
            return false;
        }

        int i = 0, j = 0;
        int count = 0;
        while(i < m && j < n) {
            if(s1.charAt(i) != s2.charAt(j)) {
                if(count == 1) {
                    return false;
                }

                // if length of one string is greater than other then only poosible edit is to remove a character
                if(m > n) {
                    i++;
                } else if(m < n) {
                    j++;
                } else {
                    i++;
                    j++;
                }

                count++;
            } else {
                i++;
                j++;
            }
        }

        if(i < m || j < n) {
            count++;
        }

        return count == 1;
    }


    public static void main(String[] args) {
        StdOut.println(checkOneEdit("pales","pale"));
        StdOut.println(checkOneEdit("pale","bake"));

    }
}

