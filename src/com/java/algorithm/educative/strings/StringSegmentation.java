package com.java.algorithm.educative.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class StringSegmentation {

  /*  public static boolean canSegmentString(String s, Set<String> dictionary) {
        for (int i = 1; i <= s.length(); ++i) {
            String first = s.substring(0, i);
            if (dictionary.contains(first)) {
                String second = s.substring(i);

                if (second == null || second.length() == 0 || dictionary.contains(second) || canSegmentString(second, dictionary)) {
                    return true;
                }

            }
        }
        return false;
    }*/

    public static boolean canSegmentString(String s, Set <String> dictionary) {
        int[] lookup = new int[s.length() + 1];
        Arrays.fill(lookup, -1);
        return canSegmentString(s,dictionary,lookup);
    }

    public static boolean canSegmentString(String s,Set<String> dictionary,int[] lookup) {
        int n = s.length();
        // base case
        if (n == 0) return true;

        if (lookup[n] == -1) {
            lookup[n] = 0;
            for (int i = 1; i <= s.length(); ++i) {
                String first = s.substring(0, i);
                if (dictionary.contains(first)) {
                    String second = s.substring(i);

                    if (second == null || second.length() == 0 || dictionary.contains(second) || canSegmentString(second, dictionary, lookup)) {
                        lookup[n] = 1;
                        return true;
                    }

                }
            }

        }

        return lookup[n] == 1;
    }

    public static void main(String[] args) {
        Set < String > dictionary = new HashSet< String >();
        String s = new String();
        s = "hellonow";

        dictionary.add("hello");
        dictionary.add("hell");
        dictionary.add("on");
        dictionary.add("now");
        if (canSegmentString(s, dictionary)) {
            System.out.println("String Can be Segmented");
        } else {
            System.out.println("String Can NOT be Segmented");
        }
    }
}
