package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/9/2018.
 */
public class EncodeDecodeString {

    public static String decode(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();++i){
            if(Character.isDigit(s.charAt(i))) {

                count = count * 10 + s.charAt(i) - '0';
            } else {
                while(count > 0) {
                    sb.append(s.charAt(i));
                    count--;
                }
            }
        }

        return sb.toString();
    }

    public static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i <= s.length(); i++) {
            if(i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            } else  {
              count++;
            }
        }

        return  sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbbaaccccccdddd";
        System.out.println("original : "+s);
        String encoded = encode(s);
        System.out.println("Encoded :"+encoded);
        System.out.println("Decoded to original :"+decode("1a30b2a6c4d"));

    }
}
