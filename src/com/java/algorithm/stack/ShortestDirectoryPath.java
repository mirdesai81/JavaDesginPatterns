package com.java.algorithm.stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ShortestDirectoryPath {
    public static String shortestDirectoryPath(String path) {

        if(path == null || path.trim().equals("")) {
            throw new IllegalArgumentException("Empty String is not legal path");
        }

        Deque<String> pathNames = new LinkedList<>();

        if(path.startsWith("/")) {
            pathNames.addFirst("/");
        }

        for(String token : path.split("/")) {
            // if .. then
            //      check if pathNames is empty or first element is .. , if yes then add .. to pathNames
            //            else check if pathnames first is '/', if yes then throw error else removefirst
            // else
            if(token.equals("..")) {
                if(pathNames.isEmpty() || pathNames.peekFirst().equals("..")) {
                    pathNames.add(token);
                } else {
                    if(pathNames.peekFirst().equals("/")) {
                        throw new IllegalArgumentException("Path error, trying to go up root "+path);
                    }

                    pathNames.removeFirst();
                }
            } else if(!token.isEmpty() && !token.equals(".")){
                    pathNames.addFirst(token);
            }
        }

        // process the pathnames
        StringBuilder result = new StringBuilder();

        if(!pathNames.isEmpty()) {
            Iterator<String> it = pathNames.descendingIterator();
            String prev= (String) it.next();
            result.append(prev);

            while(it.hasNext()) {
                if(!prev.equals("/")) {
                    result.append("/");
                }

                prev = it.next();
                result.append(prev);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String path = "sc//./../tc/awk/././";
        System.out.println(shortestDirectoryPath(path));
    }

}
