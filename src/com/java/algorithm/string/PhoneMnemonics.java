package com.java.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihir.Desai on 5/8/2018.
 */
public class PhoneMnemonics {

    private static final String[] MAPPING = {"0", "1", "ABC", "DEF", "GHI", "JKL",
            "MNO", "PQRS", "TUV", "WXYZ"};

    public static List<String> phoneMnemonic(String phoneNumber) {
        char[] partialMnemonic = new char[phoneNumber.length()];
        List<String> mnemonics = new ArrayList<>();
        phoneMnemonicHelper(phoneNumber,0,partialMnemonic,mnemonics);
        return mnemonics;
    }

    public static void phoneMnemonicHelper(String phoneNumber,int digit,char[] partialMnemonic, List<String> mnemonic) {

        if(digit == phoneNumber.length()) {
            mnemonic.add(new String(partialMnemonic));
        } else {

            for(int i = 0; i < MAPPING[phoneNumber.charAt(digit) - '0'].length(); ++i) {
                char c = MAPPING[phoneNumber.charAt(digit) - '0'].charAt(i);
                partialMnemonic[digit] = c;
                phoneMnemonicHelper(phoneNumber,digit + 1,partialMnemonic,mnemonic);
            }

        }
    }

    public static void main(String[] args) {
        List<String> mnemonics = phoneMnemonic("2023727167");
        System.out.println(mnemonics);
    }
}
