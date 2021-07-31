package com.java.algorithm.educative.array;

import java.util.ArrayList;



class MergeIntervals{
    static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {

        if(v == null || v.size() == 0) {
            return null;
        }

        ArrayList<Pair> result = new ArrayList<Pair>();

        result.add(new Pair(v.get(0).first, v.get(0).second));

        for(int i = 1 ; i < v.size(); i++) {
            int x2 = v.get(i).first;
            int y2 = v.get(i).second;
            int x1 = result.get(result.size() - 1).first;
            int y1 = result.get(result.size() - 1).second;

            if(y1 >= x2) {
                result.get(result.size() - 1).second = Math.max(y1, y2);
            } else {
                result.add(new Pair(x2, y2));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        ArrayList<Pair> v = new ArrayList<Pair>();

        v.add(new Pair(1, 5));
        v.add(new Pair(3, 7));
        v.add(new Pair(4, 6));
        v.add(new Pair(6, 8));
        v.add(new Pair(10, 12));
        v.add(new Pair(11, 15));

        ArrayList<Pair> result = mergeIntervals(v);

        for(int i=0; i<result.size(); i++){
            System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
        }
    }
}

class Pair{
    public int first;
    public int second;

    public Pair(int x, int y){
        this.first = x;
        this.second = y;
    }
}