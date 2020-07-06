package com.java;

import java.math.BigInteger;

public class StringTest {


    private static final char[] corpus   = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_".toCharArray();
    /*
     * Note if seed is unique then generated base62 number will be unique as well under load balance make sure this value is not same.
     */
    public static final String getBase64From10(final long seed)
    {
        String number = seed + "";
        char[] buf = new char[number.length()];
        int charPos = number.length() - 1;
        BigInteger bigIntegerNumber = new BigInteger(number);
        BigInteger radix = BigInteger.valueOf(64);

        while (bigIntegerNumber.compareTo(radix) >= 0)
        {
            buf[charPos--] = corpus[bigIntegerNumber.mod(radix).intValue()];
            bigIntegerNumber = bigIntegerNumber.divide(radix);
        }
        buf[charPos] = corpus[bigIntegerNumber.intValue()];
        return new String(buf, charPos, (number.length() - charPos));
    }
    /**
     * @param longNumber
     * a positive number in base 64
     * @return the same number, in base 10
     */
    public static final String getBase10From64(final String number)
    {

        BigInteger value = BigInteger.ZERO;
        for (char c : number.toCharArray())
        {
            value = value.multiply(BigInteger.valueOf(64));
            if ('0' <= c && c <= '9')
            {
                value = value.add(BigInteger.valueOf(c - '0'));
            }
            if ('a' <= c && c <= 'z')
            {
                value = value.add(BigInteger.valueOf(c - 'a' + 10));
            }
            if ('A' <= c && c <= 'Z')
            {
                value = value.add(BigInteger.valueOf(c - 'A' + 36));
            }

            //45  -
            //97 _
            if('-' == c || '_' == c) {
                value = value.add(BigInteger.valueOf(Character.getNumericValue(c)));
            }

        }
        return value.toString();
    }


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


        String base64String = getBase64From10(1634000000);
        System.out.println(base64String);

        String base10String = getBase10From64("bHznYa");
        System.out.println(base10String);

    }
}
