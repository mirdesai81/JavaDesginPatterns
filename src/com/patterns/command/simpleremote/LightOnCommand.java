package com.patterns.command.simpleremote;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class LightOnCommand implements Command {
    Light _light;
    public LightOnCommand(Light light) {
         this._light = light;
    }

    @Override
    public void execute() {
         _light.on();
    }
}
