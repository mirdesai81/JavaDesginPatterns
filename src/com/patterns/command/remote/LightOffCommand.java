package com.patterns.command.remote;

import com.patterns.command.simpleremote.LightOnCommand;

/**
 * Created by Mihir.Desai on 2/22/2016.
 */
public class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
         light.lightOff();
    }
}
