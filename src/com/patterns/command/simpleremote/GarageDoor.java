package com.patterns.command.simpleremote;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class GarageDoor {
    public void onLight() {
        System.out.println("Garage Light is on");
    }

    public void offLight() {
        System.out.println("Garage Light is off");
    }

    public void open() {
        System.out.println("Garage door is Opening");
    }

    public void close() {
        System.out.println("Garage door is Closing");
    }
}
