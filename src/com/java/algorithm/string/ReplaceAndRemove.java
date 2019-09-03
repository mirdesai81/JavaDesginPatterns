package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/1/2018.
 */
public class ReplaceAndRemove {
    public static int replaceAndRemove(int size,char[] s) {
        int writeIndex = 0;
        int aCount = 0;

        for(int i = 0; i < size; i++) {
            if(s[i] != 'b') {
                s[writeIndex++] = s[i];
            }

            if(s[i] == 'a') {
                aCount++;
            }
        }

        String data = String.format("WriteIdx %d, aCount %d",writeIndex,aCount);
        System.out.println(data);
        // curIdx is before writeIndx where last element was written and then writeIndex was incremented
        int curIdx = writeIndex - 1;
        // since last writeIndex was already incremented to reset we decrement by 1 from current writeIndex and add aCount for final write to happen
        writeIndex = writeIndex + aCount - 1;
        int finalSize = writeIndex + 1;

        while(curIdx >= 0) {
            if(s[curIdx] == 'a') {
                s[writeIndex--] = 'd';
                s[writeIndex--] = 'd';
            } else {
                s[writeIndex--] = s[curIdx];
            }
            curIdx--;
        }

        return finalSize;
    }

    private static String replaceAll(String s,int times, char r,char b) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < s.length();i++) {
            if(s.charAt(i) == r) {
                count++;
            }
        }

        int len = (n - count) + (count * times);
        StringBuilder sb = new StringBuilder(len);

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != r) {
                sb.append(s.charAt(i));
            } else {
                for(int j = 0 ; j < times; j++) {
                    sb.append(b);
                }
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        char[] s = new char[]{'a','c','b','x','a','a','x','x','x','x','x'};
        replaceAndRemove(6,s);

        for(int i = 0; i < s.length; ++i)
            System.out.print(s[i]);


        System.out.println();
        String result = replaceAll("hello",3,'l', '*');
        System.out.println(result);
    }
}
