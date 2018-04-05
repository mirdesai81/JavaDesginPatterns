package com.java.algorithm;

/**
 * Created by mihir.desai on 1/22/2018.
 */
public class GameEntry {
    private int score;
    private String name;

    public GameEntry(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
