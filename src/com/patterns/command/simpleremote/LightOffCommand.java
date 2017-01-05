package com.patterns.command.simpleremote;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class LightOffCommand implements Command {
    Light _light;
    public LightOffCommand(Light light) {
        this._light = light;
    }

    @Override
    public void execute() {
        _light.off();
    }
}
