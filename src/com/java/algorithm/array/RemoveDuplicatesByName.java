package com.java.algorithm.array;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveDuplicatesByName {

    public static class Name implements Comparable<Name> {
        String fname;
        String lname;

        public Name(String fname, String lname) {
            this.fname = fname;
            this.lname = lname;
        }

        @Override
        public int compareTo(Name o) {
            int cmp = this.fname.compareTo(o.fname);

            if(cmp != 0) {
                return cmp;
            }

            return this.lname.compareTo(o.lname);
        }

        @Override
        public String toString() {
            return "Name{" +
                    "fname='" + fname + '\'' +
                    ", lname='" + lname + '\'' +
                    '}';
        }
    }

    public static void removeDuplicates(List<Name> A) {
        Collections.sort(A);
        int writeIndex = 0;
        for(int i = 1; i < A.size(); i++) {
            if(!A.get(i).fname.equalsIgnoreCase(A.get(writeIndex).fname))
                A.set(++writeIndex,A.get(i));
        }

        A.subList(++writeIndex,A.size()).clear();
    }

    public static void main(String[] args) {
        List<Name> A = new ArrayList<>(Arrays.asList(new Name("Mihir","Desai") ,
                new Name("Mihir","Nagrath"),
                new Name("Saloni","Desai"),
                new Name("Saloni","Naik"),
                new Name("Mihir","Desai")
        ));
        removeDuplicates(A);
        StdOut.println(A);
    }


}
