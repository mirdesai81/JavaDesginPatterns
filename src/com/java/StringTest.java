package com.java;

public class StringTest {

    public static void main(String[] args) {

        // Both point to String Constant Pool
        String s1 = "CFG";
        String s2 = "CFG";
        System.out.println("s1 == s2" + (s1 == s2));


        /*
            String Interning is a method of storing only one copy of each distinct String Value, which must be immutable.
            By applying String.intern() on a couple of strings will ensure that all strings having the same contents share the same memory.
            For example, if a name ‘Amy’ appears 100 times, by interning you ensure only one ‘Amy’ is actually allocated memory.
         */
        // This point to heap
        String s3 = new String("CFG");

        // This points to String Constant Pool
        String s4 = s3.intern();
        // This checks memory location
        System.out.println("s3 == s4 "+(s3 == s4));
        // This checks contents
        System.out.println("s3.equals(s4) "+(s3.equals(s4)));

        String s5 = "CFG";
        System.out.println("s4 == s5 "+(s4 == s5));

    }
}
