package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/7/2018.
 */
public class ReverseWords {

    public static void reverseWords(char[] input) {
        // reverse entire string of input char
        reverse(input,0,input.length);

        // reverse individual words by find start and end based on space ' '

        int start = 0, end;
        while((end = find(input,' ',start)) != -1) {
            reverse(input,start,end);
            start = end + 1;
        }

        // last word reverse
        reverse(input,start,input.length);
    }

    public static void reverse(char[] input,int start, int stopIndex) {
        if(start >= stopIndex) {
            return;
        }

        int last = stopIndex - 1;
        for(int i = start; i <= start + (last - start)/2;i++) {
            char temp = input[i];
            input[i] = input[last - i + start];
            input[last - i + start] = temp;
        }
    }

    public static int find(char[] input,char c,int start) {
        for(int i = start; i < input.length; i++) {
            if(input[i] == c) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        char[] input = "Ram is costly".toCharArray();
        reverseWords(input);
        System.out.println(input);

    }
}
