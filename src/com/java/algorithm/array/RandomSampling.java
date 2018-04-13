package com.java.algorithm.array;

import java.util.*;

/**
 * Created by mihir.desai on 4/10/2018.
 */
public class RandomSampling {

    public static void randomSampling(int k,List<Integer> A){
        Random rand = new Random();
        System.out.println("Before Random sampling "+A);
        for(int i = 0; i < k; ++i) {
            int j =rand.nextInt(A.size() - i);
            Collections.swap(A,i , i + j);
            System.out.println("After Swap in range ["+i+","+j+"] "+A);
        }
        System.out.println("After Random sampling "+A);
    }

    public static List<Integer> onlineRandomSample(Iterator<Integer> sequence,int k) {
        List<Integer> runningSample = new ArrayList<>(k);
        for(int i=0; sequence.hasNext() && i < k;++i) {
            runningSample.add(sequence.next());
        }

        System.out.println("Starting running sample - " +runningSample);
        int numSeenSoFar = k;
        Random random = new Random();
        while (sequence.hasNext()) {
            Integer x = sequence.next();
            ++numSeenSoFar;
            int idToReplace = random.nextInt(numSeenSoFar);
            System.out.println("ID to replace - " + idToReplace);
            if(idToReplace < k) {
                runningSample.set(idToReplace,x);
                System.out.println("Running Sample after replace - " + runningSample);
            }
        }

        return runningSample;
    }

    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> permutation = new ArrayList<>(n);
        for(int i = 0; i < n; ++i) {
            permutation.add(i);
        }
        RandomSampling.randomSampling(permutation.size(),permutation);
        return permutation;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(3,5,7,11,12,15));
        randomSampling(3,A);

        A = new ArrayList<>(Arrays.asList(3,5,7,11,12,15));
        onlineRandomSample(A.iterator(),2);

        System.out.println(computeRandomPermutation(23));
    }
}
