package com.java.algorithm.string;

/**
 * Created by Mihir.Desai on 5/1/2018.
 */
public class ReplaceAndRemove {
    public static int replaceAndRemove(int size,char[] s) {
        int writeIndex = 0;
        int aCount = 0;

        for(int i = 0; i < size;++i) {
            if(s[i] != 'b') {
                s[writeIndex++] = s[i];
            }

            if(s[i] == 'a') {
                ++aCount;
            }
        }

        for(int i = 0; i < s.length; ++i)
            System.out.print(s[i]);

        System.out.println("writeIndex = "+writeIndex+" ,aCount = "+aCount);
        int curIdx = writeIndex - 1;
        writeIndex = writeIndex + aCount - 1;
        final int finalSize = writeIndex + 1;

        System.out.println("writeIndex = "+writeIndex+" ,curIdx = "+curIdx+" ,finalSize = "+finalSize);
        while (curIdx >= 0) {
            if (s[curIdx] == 'a') {
                s [writeIndex--] = 'd' ;
                s [writeIndex--] = 'd' ;
            } else {
                s [writeIndex--] = s[curIdx];
            }
            --curIdx ;
        }


        return finalSize;
    }

    public static void main(String[] args) {
        char[] s = new char[]{'a','b','a','c','x'};
        replaceAndRemove(4,s);

        for(int i = 0; i < s.length; ++i)
            System.out.print(s[i]);
    }
}
