package com.patterns.command.remote;

/**
 * Created by Mihir.Desai on 2/22/2016.
 */
public class GarageDoorDownCommand implements Command {
    GarageDoor garageDoor;
    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.lightOff();
        garageDoor.down();
    }
}
