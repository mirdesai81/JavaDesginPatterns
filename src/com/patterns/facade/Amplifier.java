package com.patterns.facade;

/**
 * Created by Mihir.Desai on 2/23/2016.
 */
public class Amplifier {
    String description;
    Tuner tuner;
    DvdPlayer dvd;
    CdPlayer cd;

    public Amplifier(String description) {
        this.description = description;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void setStereoSound() {
        System.out.println(description + " stereo mode on");
    }

    public void setSurroundSound() {
        System.out.println(description + " surround sound on (5 speakers , 1 subwoofer)");
    }

    public void setVolume(int level) {
        System.out.println(description + " setting volume to "+ level);
    }

    public void setTuner(Tuner tuner) {
        System.out.println(description + " setting Tuner to "+ tuner);
        this.tuner = tuner;
    }

    public void setDvd(DvdPlayer dvd) {
        System.out.println(description + " setting dvd to "+ dvd);
        this.dvd = dvd;
    }

    public void setCd(CdPlayer cd) {
        System.out.println(description + " setting cd to "+ cd);
        this.cd = cd;
    }

    public String toString() {
        return description;
    }
}
