package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 4/30/2018.
 */
public class BaseConversion {

    public static String convertBase(String num,int b1, int b2) {
        boolean isNegative = num.startsWith("-");
        int numAsInt = 0;
        int len = num.length() - 1;

        // First convert the String to base1
        for(int i = isNegative ? 1 : 0; i <= len; i++) {
            int intValue = Character.isDigit(num.charAt(i)) ?
                    num.charAt(i) - '0'
                    : num.charAt(i) - 'A' + 10;

            numAsInt = numAsInt + intValue * (int) Math.pow(b1 , len - i);

        }

        // if negative prefix - , if numAsInt == 0 then 0 else constructFromBase
        return isNegative ? "-" : "" + (numAsInt == 0 ? "0" : constructFromBase(numAsInt , b2));
    }

    private static String constructFromBase(int numAsInt,int base) {
       /* return numAsInt == 0 ?
                ""
                : constructFromBase( numAsInt / base,base)
                    + (char) (numAsInt % base >= 10
                                    ? 'A' + numAsInt % base - 10

                                   : '0' + numAsInt % base);*/

        // for decimal base is 10 but here base can be anything <= 16
        StringBuilder sb = new StringBuilder();
        do {
            final int intValue = (int)Math.abs(numAsInt % base);
            if( intValue >= 10) {
                sb.append((char)('A' + intValue - 10));
            } else {
                sb.append((char)('0' + intValue));
            }
            numAsInt = (numAsInt/base);
        } while(numAsInt != 0);


        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertBase("615",7,13));
    }
}
