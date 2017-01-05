package com.patterns.command.remote;

/**
 * Created by Mihir.Desai on 2/22/2016.
 */
public class Light {
    String location;

    public Light(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void lightOn() {
        System.out.println(location + " light is on");
    }

    public void lightOff() {
        System.out.println(location + " light is off");
    }
}
