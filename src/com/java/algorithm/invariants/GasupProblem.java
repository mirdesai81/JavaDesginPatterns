package com.java.algorithm.invariants;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GasupProblem {
    private static final int MPG = 20;

    private static class CityAndRemainingGas {
        public Integer city;
        public Integer remainingGallons;

        public CityAndRemainingGas(Integer city, Integer remainingGallons) {
            this.city = city;
            this.remainingGallons = remainingGallons;
        }
    }

    // city i to the next city
    public static int findAmpleCity(List<Integer> gallons, List<Integer> distances) {
        int remainingGallons = 0;
        CityAndRemainingGas min = new CityAndRemainingGas(0,0);
        final int numCities = gallons.size();
        for(int i = 1; i < numCities; i++) {
            remainingGallons = remainingGallons + gallons.get(i - 1) - (distances.get(i - 1) / MPG);

            if(remainingGallons < min.remainingGallons) {
                min = new CityAndRemainingGas(i,remainingGallons);
            }
        }

        return min.city;
    }

    public static void main(String[] args) {
        List<Integer> gallons = new ArrayList<>(Arrays.asList(50,20,5,30,25,10,10));
        List<Integer> distances = new ArrayList<>(Arrays.asList(900,600,200,400,600,200,100));

        StdOut.println(findAmpleCity(gallons,distances));
    }


}
