package com.java.algorithm.array;

/**
 * Created by mihir.desai on 4/2/2018.
 * Write a program which takes as input two strings s and t of bits encoding
 * binary numbers Bs and B, respectively, and returns a new string of bits representing
 * the number Bs + Bt.
 */
public class AddBinaryNumbers {

    public static String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();

        int rem = Math.abs(lenA - lenB);
        while (rem > 0) {
            sb.append("0");
            rem--;
        }

        if(lenA > lenB) {
            sb.append(b);
            b = sb.toString();
        } else {
            sb.append(a);
            a = sb.toString();
        }

        sb = new StringBuilder();
        char carry = '0';
        int i = a.length() - 1;

        while(i >= 0) {
            // both are either '0' or '1'
            if(a.charAt(i) == b.charAt(i)) {
                // always append carry for '1' or '0'
                sb.append(carry);

                // if both are '1' then carry is '1'
                if(a.charAt(i) == '1') {
                    carry = '1';
                } else {
                    carry = '0';
                }

            } else {
                // one is '0' and other is '1'
                // if carry was  '1' then 1 + 1 = 0 and new carry = 1
                if(carry == '1') {
                    sb.append('0');
                    carry = '1';
                } else {
                    sb.append('1');
                    carry = '0';
                }
            }

            i--;
        }

        // at the end if carry was '1' then carry over forward
        if(carry == '1') {
            sb.append('1');
        }

        // reverse the string
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(addBinary("111","101"));
    }
}
