package com.patterns.command.remote;

import com.patterns.command.simpleremote.*;

/**
 * Created by Mihir.Desai on 2/22/2016.
 */
public class GarageDoorUpCommand implements Command {

    GarageDoor garageDoor;
    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
        garageDoor.lightOn();
    }
}
