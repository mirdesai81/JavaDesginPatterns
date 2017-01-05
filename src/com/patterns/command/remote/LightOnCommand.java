package com.patterns.command.remote;

/**
 * Created by Mihir.Desai on 2/22/2016.
 */
public class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOn();
    }
}
