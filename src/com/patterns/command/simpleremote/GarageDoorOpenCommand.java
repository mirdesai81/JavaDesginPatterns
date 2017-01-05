package com.patterns.command.simpleremote;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor _garageDoor;
    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this._garageDoor = garageDoor;
    }

    public void execute() {
        _garageDoor.open();
    }
}
