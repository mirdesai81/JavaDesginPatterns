package com.java.algorithm.string;

import com.java.stdlib.StdOut;

public class StringRotateCheck {

    public static boolean isStringRotationOfAnother(String s1, String s2) {
        s1 = s1 + s1;
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        StdOut.println(isStringRotationOfAnother("waterbottle","erbottlewat"));
    }
}
