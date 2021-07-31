package com.java.algorithm.educative.stackAndQueue;

import java.util.*;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Deque<String> queue = new LinkedList<String>();
        queue.addLast("1");
        for(int i = 0; i < n; i++) {
            String val = queue.poll();
            result.add(val);
            queue.addLast(val + "0");
            queue.addLast(val + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateBinary(8));
    }

}
