package com.java.algorithm;

/**
 * Created by mihir.desai on 1/22/2018.
 */
public class                                            Scoreboard {
    private int numOfEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();

        if(numOfEntries < board.length || newScore > board[numOfEntries-1].getScore()){
            if(numOfEntries < board.length) {
                numOfEntries++;
            }

            int j = numOfEntries - 1;
            while(j > 0 && board[j-1].getScore() < newScore){
                board[j] = board[j -1];
                j--;
            }

            board[j] = e;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if(i == 0 || i >=numOfEntries){
            throw new IndexOutOfBoundsException("Invalid index - "+i);
        }

        GameEntry entry = board[i];
        // move entries from right to left
        for(int j = i; j < numOfEntries - 1;j++) {
            board[j] = board[j + 1];
        }
        board[numOfEntries -1] = null;
        numOfEntries--;
        return entry;
    }

}
