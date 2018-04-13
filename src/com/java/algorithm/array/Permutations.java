package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mihir.desai on 4/10/2018.
 */
public class Permutations {

    public static void applyPermutations(List<Integer> perm,List<Integer> A) {
        for(int i = 0; i < A.size(); ++i) {
            boolean isMin = true;
            int j = perm.get(i);
            while(i != j) {
                if( j < i) {
                    isMin = false;
                    break;
                }
                j = perm.get(j);
            }

            if(isMin) {
                cyclicPermutation(i,perm,A);
                System.out.println(A);
            }
        }
    }

    private static void cyclicPermutation(int start,List<Integer> perm, List<Integer> A) {
        int i = start;
        int temp = A.get(start);
        do {
            int nextI = perm.get(i);
            int nextITemp = A.get(nextI);
            A.set(nextI,temp);
            i = nextI;
            temp = nextITemp;
        } while(i != start);
    }

    public static List<Integer> nextPermutation(List<Integer> perm) {
        int k = perm.size() - 2;
        // find k such that perm[k] < perm[k + 1] and entries after k appear in decreasing order
        while(k >= 0 && perm.get(k) >= perm.get(k + 1)) {
            --k;
        }

        if(k == -1){
            return Collections.emptyList();
        }

        // find the smallest perm[i] such that perm[i] > perm[k].
        // swap perm[i] and perm[k]
        for(int i = perm.size() - 1; i > k; --i) {
            if(perm.get(i) > perm.get(k)) {
                Collections.swap(perm,k,i);
                break;
            }
        }

        // since perm.sublist(k + 1, perm.size()) is in decreasing order we can
        // built smallest dictionary ordering of this subarray by reversing it.
        Collections.reverse(perm.subList(k+1,perm.size()));
        return perm;
    }

    public static List<Integer> kthPermutation(List<Integer> perm,int k) {

        for(int i = 1; i <= k; ++i) {
            perm = nextPermutation(perm);
        }

        return perm;
    }

    public static List<Integer> prevPermutation(List<Integer> perm) {
        int k = perm.size() - 2;
        // find k such that p[k] > p[k + 1] and entries after k appears in increasing order
        // eg 4,0,1,3,5 where p[k] = 4 and entries after p[k] 0,1,3,5 are in increasing order
        while(k >=0 && perm.get(k) <= perm.get(k + 1)) {
            --k;
        }

        if(k == -1){
            return Collections.emptyList();
        }
        /*System.out.println("prev k - "+perm.get(k));*/
        //find i where p[i] < p[k] from the end
        //  eg 4,0,1,3,5 where p[k] = 4 and
        for(int i = perm.size() - 1; i > k; --i) {
            if(perm.get(i) < perm.get(k)) {
                Collections.swap(perm,k,i);
                break;
            }
        }

        /*System.out.println("after swap k and i - "+perm);*/
        Collections.reverse(perm.subList(k+1,perm.size()));
        return perm;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(10,20,30,40));
        List<Integer> perm = new ArrayList<>(Arrays.asList(3,2,1,0));
        applyPermutations(perm,A);

        perm = new ArrayList<>(Arrays.asList(6,2,3,5,4,1,0));
        System.out.println("Input permutation -" + perm);
        perm = nextPermutation(perm);
        System.out.println("Next permutation -" + perm);

        perm = prevPermutation(perm);
        System.out.println("Prev permutation -" + perm);

        perm =  new ArrayList<>(Arrays.asList(0,1,2,3));
        System.out.println("For K=23 Permutation "+kthPermutation(perm,23));
    }
}
