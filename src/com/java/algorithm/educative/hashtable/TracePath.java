package com.java.algorithm.educative.hashtable;

import java.util.HashMap;
import java.util.Map;

public class TracePath {

    public static String tracePath(Map<String,String> map) {

        String result = "";
        HashMap<String,String> reverseMap = new HashMap<>(map.size());
        for(Map.Entry<String,String> entry : map.entrySet()) {
            reverseMap.put(entry.getValue(),entry.getKey());
        }

        int count = 0;
        String from = "";
        for(Map.Entry<String,String> entry : map.entrySet()) {
            if(!reverseMap.containsKey(entry.getKey())) {
                from = entry.getKey();
                count++;
            }
        }

        if(count > 1) {
            return "null";
        }

        String to = map.get(from);

        while(to != null) {
            result += from + "->" + to + ", ";
            from = to;
            to = map.get(to);
        }

        // Write - Your - Code
        // return result.substring(0,result.length() - 1);
        return result;
    }

    public static void main(String[] args) {
        Map<String,String> hMap = new HashMap<>();

        hMap.put("NewYork","Chicago");
        hMap.put("Boston","Texas");
        hMap.put("Missouri","NewYork");
        hMap.put("Texas","Missouri");

        String actual_output = tracePath(hMap);

        System.out.println(actual_output);
    }
}
