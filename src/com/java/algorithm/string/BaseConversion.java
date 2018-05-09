package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 4/30/2018.
 */
public class BaseConversion {

    public static String convertBase(String num,int b1, int b2) {
        boolean isNegative = num.startsWith("-");
        int numAsInt = 0;
        for(int i = (isNegative ? 1 : 0);i < num.length(); ++i) {
           /* numAsInt *= b1;*/
            int numValue = Character.isDigit(num.charAt(i)) ? num.charAt(i) - '0' : num.charAt(i) - 'A' + 10;
            System.out.println("numValue = "+numValue+", multiply = "+(int)Math.pow(b1,num.length() - 1 - i));
            numAsInt += numValue * (int)Math.pow(b1,num.length() - 1 - i);
            System.out.println("numAsInt = "+numAsInt);
        }
        return (isNegative ? "-" : "") + (numAsInt == 0 ? "0" : constructFromBase(numAsInt,b2));
    }

    public static String constructFromBase(int numAsInt,int base) {
       /* return numAsInt == 0 ?
                ""
                : constructFromBase( numAsInt / base,base)
                    + (char) (numAsInt % base >= 10
                                    ? 'A' + numAsInt % base - 10

                                   : '0' + numAsInt % base);*/
        boolean isNegative = false;
        if(numAsInt < 0) {
            isNegative = true;
        }
        StringBuilder sb = new StringBuilder();
        do {
            if((int)Math.abs(numAsInt % base) >= 10) {
                sb.append((char)('A' + Math.abs(numAsInt % base) - 10));
            } else {
                sb.append((char)('0' + Math.abs(numAsInt % base)));
            }
            numAsInt = (numAsInt/base);
        } while(numAsInt != 0);

        if(isNegative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertBase("615",7,13));
    }
}
