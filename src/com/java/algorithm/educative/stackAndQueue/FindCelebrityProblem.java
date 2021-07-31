package com.java.algorithm.educative.stackAndQueue;

class FindCelebrityProblem {

    public static boolean knows(int[][] party,int i, int j) {
        if(party[i][j] == 1) return true;

        return false;
    }
    public static int findCelebrity(int[][] party, int numPeople) {
        int celebrity = -1;
        // Write -- Your -- Code
        Stack<Integer> stack = new Stack<>(numPeople);
        for(int i = 0; i < numPeople; i++) {
            stack.push(i);
        }

        while(!stack.isEmpty()) {

            int p1 = stack.pop();

            if(stack.isEmpty()) {
                celebrity = p1;
                break;
            }

            int p2= stack.pop();
            int val  = party[p1][p2];
            if(knows(party,p1,p2)) {
                stack.push(p2);
            } else {
                stack.push(p1);
            }

        }

        for(int i = 0; i < numPeople; i++) {
            // if celebrity knows anyone or any of others does not celebrity then return -1
            if(celebrity != i && (knows(party,celebrity,i) || !knows(party,i,celebrity))) return -1;
        }

        return celebrity;
    }


    public static void main(String args[]) {

        int [][] party1 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,0},
                {0,1,1,0},
        };

        int [][] party2 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,1},
                {0,1,1,0},
        };

        int [][] party3 = {
                {0,0,0,0},
                {1,0,0,1},
                {1,0,0,1},
                {1,1,1,0},
        };

        System.out.println(findCelebrity(party1,4));
        System.out.println(findCelebrity(party2,4));
        System.out.println(findCelebrity(party3,4));
    }
}