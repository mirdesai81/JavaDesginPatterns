package com.patterns.command.simpleremote;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class SimpleRemoteControl {

    Command _command;

    public void setCommand(Command command) {
        this._command = command;
    }

    public void buttonPressed() {
        _command.execute();
    }
}
