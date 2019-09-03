package com.java.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihir.Desai on 5/9/2018.
 */
public class IPAddress {

    public static List<String> getValidIPAddress(String s) {

        List<String> result = new ArrayList<>();

        for(int i = 1; i < 4 && i < s.length();i++) {
            String first = s.substring(0,i);
            if(isValid(first)) {
                for(int j = 1; i + j < s.length() && j < 4;j++) {
                    String second = s.substring(i, i + j);
                    if(isValid(second)) {
                        for(int k = 1; i + j + k < s.length() && k < 4;k++) {
                            String third = s.substring(i + j,i + j + k);
                            String fourth = s.substring(i + j + k);
                            if(isValid(third) && isValid(fourth)) {
                                result.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }

        return  result;
    }

    public static boolean isValid(String s) {
        if(s.length() > 3) {
            return false;
        }

        // 00 , 01 , 001 all are invalid but 0 is valid
        if(s.startsWith("0") && s.length() > 1) {
            return false;
        }

        try {
            int value = Integer.parseInt(s);
            return value <= 255 && value >= 0;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(getValidIPAddress("19216811"));
    }

}
