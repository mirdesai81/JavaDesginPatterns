package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 4/30/2018.
 */
public class StringConversion {

    public static String intToString(int x) {
        boolean isNegative = false;
        if(x < 0) {
            isNegative = true;
        }

        StringBuilder sb = new StringBuilder();

        do {
            sb.append((char)('0' + Math.abs(x % 10)));
            x = x/10;
        } while(x != 0);

        if(isNegative) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }

    public static int stringToInt(String s) {
        int result = 0;
        for(int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i) {
            final int digit = s.charAt(i) - '0';
            result = (result * 10) + digit;
        }

        return s.charAt(0) == '-' ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(intToString(-12345678));
        System.out.println(stringToInt("-12345"));
    }
}
