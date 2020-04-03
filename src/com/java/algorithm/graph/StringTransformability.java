package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.*;

public class StringTransformability {

    private static class StringWithDistance {
        public String candidateString;
        public Integer distance;

        public StringWithDistance(String candidateString, Integer distance) {
            this.candidateString = candidateString;
            this.distance = distance;
        }
    }

    public static int transformString(Set<String> D, String s, String t) {
        Set<String> visited = new HashSet<>(D);

        Queue<StringWithDistance> q = new LinkedList<>();
        visited.remove(s);
        q.add(new StringWithDistance(s,0));

        StringWithDistance f;

        while((f = q.poll()) != null) {
            if(f.candidateString.equals(t)) {
                return f.distance;
            }

            String str = f.candidateString;

            for(int i = 0; i < str.length(); ++i) {
                String start = i == 0 ? "" : str.substring(0, i);
                String end = i + 1 < str.length() ? str.substring(i + 1) : "";

                for(int c = 0; c < 26; ++c) {
                    String modStr = start + (char) ('a' + c) + end;

                    if(visited.contains(modStr)) {
                        visited.remove(modStr);
                        q.add(new StringWithDistance(modStr, f.distance + 1));
                    }
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        // ["bat", "cot", "dog", "dag", "dot", "cat"]	cat	dog
        Set<String> D = new HashSet<>(new ArrayList<String>(Arrays.asList("bat", "cot", "dog", "dag", "dot", "cat")));
        StdOut.println(transformString(D,"cat", "dog"));
    }
}
