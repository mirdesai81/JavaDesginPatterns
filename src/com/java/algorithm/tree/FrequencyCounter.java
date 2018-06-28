package com.java.algorithm.tree;

import com.java.stdlib.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Mihir.Desai on 4/25/2017.
 */
public class FrequencyCounter {

    private FrequencyCounter() {

    }

    public static void main(String[] args) {
        int distinct = 0, words = 0;
        Scanner scanner = null;
        try {
            int minLength = Integer.parseInt(args[0]);
            scanner = new Scanner(new File(args[1]));
            StdOut.println("min length:" + minLength);
            ST<String, Integer> st = new ST<>();
            while (scanner.hasNext()) {
                String key = scanner.next();
                if (key.length() < minLength) continue;
                words++;
                if (st.contains(key)) {
                    st.put(key, st.get(key) + 1);
                } else {
                    st.put(key, 1);
                    distinct++;
                }
            }

            // find key with highest frequency
            String max = "";
            st.put(max, 0);
            for (String word : st.keys()) {
                if (st.get(word) > st.get(max)) {
                    max = word;
                }
            }

            StdOut.println(max + " " + st.get(max));
            StdOut.println("distinct = " + distinct);
            StdOut.println("words    = " + words);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(scanner!= null)
                scanner.close();
        }
    }
}
