package com.java.algorithm.dp;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfCombinationForFinalScore {

    public static int numOfCombinationForFinalScore(int finalScore, List<Integer> individualPlayScores) {

        int[][] numCombinationsForScore = new int[individualPlayScores.size()][finalScore + 1];

        for(int i = 0; i< individualPlayScores.size(); i++) {
            numCombinationsForScore[i][0] = 1;
            for(int j = 1; j <= finalScore; j++) {


                int withoutThisPlay = i >= 1 ? numCombinationsForScore[i - 1][j] : 0;
                int withThisPlay = j >= individualPlayScores.get(i) ? numCombinationsForScore[i][j - individualPlayScores.get(i)] : 0;
                numCombinationsForScore[i][j] = withoutThisPlay + withThisPlay;
            }
        }

        return numCombinationsForScore[individualPlayScores.size() - 1][finalScore];
    }

    public static int numOfCombinationForFinalScoreWithLessSpace(int finalScore,List<Integer> individualPlayScores) {
        int i;
        int[] numOfCombinations = new int[finalScore + 1];
        numOfCombinations[0] = 1;

        for(Integer score : individualPlayScores) {
            for(i = score; i <= finalScore; i++) {
                numOfCombinations[i] += numOfCombinations[i - score];
            }
        }



        return numOfCombinations[finalScore];
    }

    public static int numOfSequences(int finalScore,List<Integer> individualPlayScores) {
        int i;
        int[] numOfPermutations = new int[finalScore + 1];
        numOfPermutations[0] = 1;


        for(i = 0; i <= finalScore; i++) {
            for(Integer score : individualPlayScores) {
                if(i >= score) {
                    numOfPermutations[i] += numOfPermutations[i - score];
                }
            }
        }


        return numOfPermutations[finalScore];
    }



    public static final void main(String[] args) {
        List<Integer> individualPLayScores = new ArrayList<>(Arrays.asList(3,2,7));
        StdOut.println(numOfCombinationForFinalScore(24,individualPLayScores));
        StdOut.println(numOfCombinationForFinalScoreWithLessSpace(24,individualPLayScores));
        StdOut.println(numOfSequences(12,individualPLayScores));
    }
}
