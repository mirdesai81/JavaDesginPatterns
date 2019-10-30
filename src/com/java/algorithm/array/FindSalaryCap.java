package com.java.algorithm.array;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSalaryCap {

    public static double findSalaryCap(List<Double> salaries,double targetPayroll) {
        Collections.sort(salaries);
        double unadjustedSalarySum = 0;

        for(int i = 0; i < salaries.size();i++) {
            double adjustedSalaraySum = salaries.get(i) * (salaries.size() - i);
            if(unadjustedSalarySum + adjustedSalaraySum >= targetPayroll) {
                return (targetPayroll - unadjustedSalarySum)/(salaries.size() - i);
            }

            unadjustedSalarySum += salaries.get(i);
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Double> salaries = new ArrayList<Double>(Arrays.asList(90.0,40.0,30.0,100.0,20.0));
        StdOut.println(findSalaryCap(salaries,210.0));
    }
}
