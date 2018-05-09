package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/1/2018.
 */
public class StringDecodingFromInteger {
    public static int StringDecode(final String col) {
        int result = 0;
        for(int i = 0; i < col.length(); i++) {
            char c = col.charAt(i);
            result = result * 26 + c - 'A' + 1;
        }

        return result;
    }

    public static int StringDecodeStartWithZero(final String col) {
        int result = 0;
        for(int i = 0; i < col.length(); i++) {
            char c = col.charAt(i);
            result = result * 26 + c - 'A' + 1;
        }

        return result;
    }

    public static String StringEncode(int col) {
        StringBuilder sb = new StringBuilder();

        do {
            int num = (col-1) % 26;
            /*System.out.println(num);*/
            sb.append((char)( 'A' + num));
           col = ((col - (num+1))/26);
           /* System.out.println(col);*/
        } while (col != 0);




        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("String to Int starting A = 0 :" + StringDecodeStartWithZero("AA"));
        System.out.println("String to Int starting A = 1 :"+StringDecode("ZZ"));
        System.out.println("Int to Char starting A = 1 :"+StringEncode(4));
        System.out.println("Int to Char starting A = 1 :"+StringEncode(702));
    }
}
