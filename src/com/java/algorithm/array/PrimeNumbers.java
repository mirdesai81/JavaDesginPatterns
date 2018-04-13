package com.java.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mihir.desai on 4/9/2018.
 */
public class PrimeNumbers {

    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1,true));
        isPrime.set(0,false);
        isPrime.set(1,false);
        for(int p = 2; p <= n; p++) {
            if(isPrime.get(p)){
                primes.add(p);
                for(int j = p ; j <=n; j+=p) {
                    isPrime.set(j,false);
                }
            }
        }

        return primes;
    }

    public static List<Integer> generatePrimesFast(int n) {
        List<Integer> primes = new ArrayList<>();
        int size = (int) Math.floor(0.5 *(n - 3)+1);
        System.out.println("Size  - "+size);
        primes.add(2);
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size,true));
        for(int i = 0; i < size; ++i) {
            if(isPrime.get(i)) {
                // prime 2*i + 3
                int p = ((2*i) + 3);
                primes.add(p);
                System.out.println("Prime - "+p);
                // Sieving from p^2 whose is 4i^2 + 12i + 9. The index of this value in isPrime is 2i^2 + 6i + 3
                // because isPrime.get(i) represents 2i + 3
                // long type for j because p^2 might overflow
                for(long j = (2*(i*i)) + 6 * i + 3; j < size; j += p) {
                    System.out.println("isPrime - "+(int)j);
                    isPrime.set((int) j, false);
                }
            }
        }

        return primes;
    }

    public static void main(String[] args){
        List<Integer> primes = generatePrimesFast(100);
        System.out.println(primes);
    }
}
