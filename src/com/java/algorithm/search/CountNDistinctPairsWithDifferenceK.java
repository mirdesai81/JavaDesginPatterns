package com.java.algorithm.search;

import com.java.stdlib.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountNDistinctPairsWithDifferenceK {

   public static List<List<Integer>> countNDistinct(List<Integer> A,int k) {
       List<List<Integer>> result = new ArrayList<>();
       for(int i = 0; i < A.size(); i++) {
           DistinctPair distinctPair = binarySearch(A,i+ 1,A.size() - 1, A.get(i),k);
           if(distinctPair.flag) {
               result.add(new ArrayList<>(Arrays.asList(distinctPair.num1,distinctPair.num2)));
           }
       }

       return result;
   }


    private static DistinctPair binarySearch(List<Integer> A,int low, int high, int current,int k) {
        if(low > high) { return
                new DistinctPair(current,A.get(high),false);
        }

        int mid = low + (high - low)/2;
        int num = current + k;
        if(A.get(mid) == num) {
            return new DistinctPair(current,A.get(mid),true);
        } else if(A.get(mid) > num) {
            return binarySearch(A,low,mid - 1,current,k);
        } else {
            return binarySearch(A,mid + 1, high,current,k);
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5,7,9));
        System.out.println(countNDistinct(A,3));
    }

    private static class DistinctPair {
       Integer num1;
       Integer num2;
       Boolean flag;

        public DistinctPair(Integer num1, Integer num2, Boolean flag) {
            this.num1 = num1;
            this.num2 = num2;
            this.flag = flag;
        }
    }

}
